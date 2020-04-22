package com.sudheer.securebank.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class RandomCardDetailsService {
	public long genCardNumber()
	{
		 Random r = new Random();
		    long numbers = 1000000000000000L + (long)(r.nextDouble() * 999999999999999L);

		    return numbers;
		
		
		
	}
	public int genCvv()

	{

		Random random = new Random();

		// generate a random integer from 0 to 899, then add 100
		int x = random.nextInt(900) + 100;
		return x;
		
	}
	
	public long genAccountNumber()
	{
		 Random r = new Random();
		    long numbers = 10000000000L + (long)(r.nextDouble() * 9999999999L);

		    return numbers;
		    }
	
}
