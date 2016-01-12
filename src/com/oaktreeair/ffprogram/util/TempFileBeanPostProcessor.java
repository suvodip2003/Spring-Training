package com.oaktreeair.ffprogram.util;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.oaktreeair.ffprogram.TempFileAware;

@Component
public class TempFileBeanPostProcessor implements BeanPostProcessor
{

	@Override
	public Object postProcessAfterInitialization(Object bean, String name)
			throws BeansException
	{
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String name)
			throws BeansException
	{
		if(bean instanceof TempFileAware)
		{
			try
			{
				TempFileAware tfa = (TempFileAware)bean;
				File tempFile = File.createTempFile("data", null,
				        new File(System.getProperty("user.dir")));
				tfa.setTempFile(tempFile);
				System.out.println("Injected tempFile into: " + name);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}			
		}
		
		return bean;
	}

}
