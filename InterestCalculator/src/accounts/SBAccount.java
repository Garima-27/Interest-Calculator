package accounts;
import main.*;
public class SBAccount extends Account
{
	double interestRate,amount;
	public SBAccount(double i,double amount)
	{
		interestRate=i;
		this.amount=amount;
	}
	public double calculateInterest()
	{
		double result=(interestRate*amount)/100;
		return result;
	}
}
