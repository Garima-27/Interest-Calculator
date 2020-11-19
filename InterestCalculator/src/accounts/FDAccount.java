package accounts;

public class FDAccount 
{
	double interestRate,amount;
	int days,age;
	public FDAccount(double am,int days,int age)
	{
		amount=am;
		this.days=days;
		this.age=age;
	}
	public double calculateInterest()
	{
		if(amount<10000000)
		{
			if(days>=7 && days<=14)
			{
				if(age>=60)
					interestRate=5.00;
				else
					interestRate=4.50;
			}
			else if(days>=15 && days<=29)
			{
				if(age>=60)
					interestRate=5.25;
				else
					interestRate=4.75;
			}
			else if(days>=30 && days<=45)
			{
				if(age>=60)
					interestRate=5.50;
				else
					interestRate=6.00;
			}
			else if(days>=45 && days<=60)
			{
				if(age>=60)
					interestRate=7.50;
				else
					interestRate=7.00;
			}
			else if(days>=61 && days<=184)
			{
				if(age>=60)
					interestRate=7.50;
				else
					interestRate=8.00;
			}
			else if(days>=185 && days<=366)
			{
				if(age>=60)
					interestRate=8.50;
				else
					interestRate=8.00;
			}
			else
				return -1;
			return (interestRate*amount)/100;
		}
		else
		{
			if(days>=7 && days<=14)
				interestRate=6.50;
			else if(days>=15 && days<=29)
				interestRate=6.25;
			else if(days>=30 && days<=45)
				interestRate=6.75;
			else if(days>=46 && days<=60)
				interestRate=8;
			else if(days>=61 && days<=184)
				interestRate=8.50;
			else if(days>=185 && days<=366)
				interestRate=10.00;
			else
				return -1;
			return (interestRate*amount)/100;
		}
	}
}
