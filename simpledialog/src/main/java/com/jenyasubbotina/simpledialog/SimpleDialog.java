package com.jenyasubbotina.simpledialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

public class SimpleDialog
{
    private final Activity activity;
    private final int colorHeader;
    private final int image;
    private final String title;
    private final String message;
    private final String textPositive;
    private final String textNegative;
    private final int colorPositive;
    private final int colorNegative;

    private SimpleDialog(Maker maker)
    {
        this.activity = maker.activity;
        this.colorHeader = maker.colorHeader;
        this.image = maker.image;
        this.title = maker.title;
        this.message = maker.message;
        this.textPositive = maker.textPositive;
        this.textNegative = maker.textNegative;
        this.colorPositive = maker.colorPositive;
        this.colorNegative = maker.colorNegative;
    }

    public static class Maker {
        private final Activity activity;
        private int colorHeader;
        private int image;
        private String title;
        private String message;
        private String textPositive;
        private String textNegative;
        private int colorPositive;
        private int colorNegative;

        public Maker(Activity activity) {
            this.activity = activity;
        }

        public Maker setColorHeader(int colorHeader) {
            this.colorHeader = colorHeader;
            return this;
        }

        public Maker setImage(int image) {
            this.image = image;
            return this;
        }

        public Maker setTitle(String title) {
            this.title = title;
            return this;
        }

        public Maker setMessage(String message) {
            this.message = message;
            return this;
        }

        public Maker setTextPositive(String textPositive) {
            this.textPositive = textPositive;
            return this;
        }

        public Maker setTextNegative(String textNegative) {
            this.textNegative = textNegative;
            return this;
        }

        public Maker setColorPositive(int colorPositive) {
            this.colorPositive = colorPositive;
            return this;
        }

        public Maker setColorNegative(int colorNegative) {
            this.colorNegative = colorNegative;
            return this;
        }

        public SimpleDialog build() {
            final Dialog alertdialog;
            TextView tvTitle;
            TextView tvMessage;
            ImageView ivHeader;
            ImageView ivImage;
            Button bPositive;
            Button bNegative;
            Button bClose;
            alertdialog = new Dialog(activity);
            alertdialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            alertdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            alertdialog.setContentView(R.layout.simpledialog);
            ivHeader = alertdialog.findViewById(R.id.background);
            ivImage = alertdialog.findViewById(R.id.icon);
            tvTitle = alertdialog.findViewById(R.id.title);
            tvMessage = alertdialog.findViewById(R.id.message);
            bPositive = alertdialog.findViewById(R.id.btn_positive);
            bNegative = alertdialog.findViewById(R.id.btn_negative);
            bClose = alertdialog.findViewById(R.id.btn_close);
            tvTitle.setText(title);
            tvMessage.setText(message);

            bPositive.setText(textPositive != null ? textPositive : "Accept");
            bPositive.setBackground(ContextCompat.getDrawable(activity.getApplicationContext(), R.drawable.positive_button));
            bPositive.getBackground().clearColorFilter();
            bPositive.getBackground().setColorFilter(colorPositive, PorterDuff.Mode.MULTIPLY);

            bNegative.setText(textNegative != null ? textNegative : "Cancel");
            bNegative.setBackground(ContextCompat.getDrawable(activity.getApplicationContext(), R.drawable.positive_button));
            bNegative.getBackground().clearColorFilter();
            bNegative.getBackground().setColorFilter(colorNegative, PorterDuff.Mode.MULTIPLY);

            ivImage.setImageResource(image);
            ivHeader.setBackgroundColor(colorHeader);

            alertdialog.show();

            return new SimpleDialog(this);

        }
    }

}
