package app;

import control.ExchangeOperation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.CurrencySet;
import swing.MoneyCalculatorFrame;

public class Application {

    public static void main(String[] args) {
        CurrencySet currencySet = new mockpersistance.CurrencySetLoader().load();
        // se crean con el mock especificamente
        MoneyCalculatorFrame frame = new MoneyCalculatorFrame(currencySet.toArray());
        // le llegan los currencies
        // se registra lo que quiero uqe pase cuando ocurra un evento
        frame.registerActionInCalculateButton(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new ExchangeOperation(frame.getExchangeDialog()).execute());
                }
        });
    }
    
}