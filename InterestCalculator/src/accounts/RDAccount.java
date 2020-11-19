package accounts;
public class RDAccount 
{
	double interestRate,amount,monthlyAmount;
	int months,age;
	public RDAccount(double am,double ma,int months,int age)
	{
		amount=am;
		monthlyAmount=ma;
		this.months=months;
		this.age=age;
	}
	public double calculateInterest()
	{
		if(months==6)
		{
			if(age>=60)
				interestRate=8.00;
			else
				interestRate=7.50;
		}
		else if(months==9)
		{
			if(age>=60)
				interestRate=8.25;
			else
				interestRate=7.75;
		}
		else if(months==12)
		{
			if(age>=60)
				interestRate=8.50;
			else
				interestRate=8.00;
		}
		else if(months==15)
		{
			if(age>=60)
				interestRate=8.75;
			else
				interestRate=8.25;
		}
		else if(months==18)
		{
			if(age>=60)
				interestRate=8.50;
			else
				interestRate=9.00;
		}
		else if(months==21)
		{
			if(age>=60)
				interestRate=9.25;
			else
				interestRate=8.75;
		}
		else return -1;	
		return (interestRate*(monthlyAmount*months))/100;
	}
}
