package com.example.iqinvest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
    public class EarningFragment extends Fragment {
        private int balance;

        public void onClick() {
            balance += 1;
            updateUI();
        }

        private void updateUI() {
            // Обновить отображение баланса
        }
    }