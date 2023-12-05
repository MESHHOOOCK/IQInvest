package com.example.iqinvest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class ShopFragment extends Fragment {
    private int balance;
    private int passiveIncome;

    public void onPurchaseItemClick(int itemPrice) {
        if (balance >= itemPrice) {
            balance -= itemPrice;
            passiveIncome += calculatePassiveIncome(itemPrice);
            itemPrice = calculateNewItemPrice(itemPrice);
            // Обновить отображение баланса и пассивного дохода
        } else {
            // Показать сообщение об ошибке - недостаточно средств
        }
    }

    private int calculatePassiveIncome(int price) {
        return price / 7 * 24;
    }

    private int calculateNewItemPrice(int oldPrice) {
        return (int) (oldPrice * 1.2);
    }
}