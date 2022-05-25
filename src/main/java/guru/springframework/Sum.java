package guru.springframework;

public class Sum implements Expression{
    final Expression augment;
    final Expression addmend;

    public Sum(Expression augmend, Expression addmend) {
        this.augment = augmend;
        this.addmend = addmend;
    }

    @Override
    public Money reduce(Bank bank, String to){
        int amount = this.addmend.reduce(bank,to).amount + this.augment.reduce(bank,to).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addmend);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(augment.times(multiplier), addmend.times(multiplier));
    }
}
