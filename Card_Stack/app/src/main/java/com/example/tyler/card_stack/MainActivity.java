package com.example.tyler.card_stack;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private TextView tv_upper;
    private TextView tv_lower;
    private ImageView iv_upper;
    private ImageView iv_center;
    private ImageView iv_lower;
    private Stack<card> cardStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tv_lower = (TextView) findViewById(R.id.tv_bottomright);
        this.iv_lower = (ImageView) findViewById(R.id.iv_bottomright);
        this.iv_center = (ImageView) findViewById(R.id.iv_center);
        this.tv_upper = (TextView) findViewById(R.id.tv_topleft);
        this.iv_upper = (ImageView) findViewById(R.id.iv_topleft);

        this.cardStack = new Stack<>();

        //All cards 1-10
        for (int i = 1; i < 11; ++i)
        {
            String val = Integer.toString(i);
            this.cardStack.push(new card(val, card.suit.HEARTS));
            this.cardStack.push(new card(val, card.suit.DIAMONDS));
            this.cardStack.push(new card(val, card.suit.SPADES));
            this.cardStack.push(new card(val, card.suit.CLUBS));
        }

        //Face cards
        this.cardStack.push(new card("J", card.suit.HEARTS));
        this.cardStack.push(new card("J", card.suit.CLUBS));
        this.cardStack.push(new card("J", card.suit.DIAMONDS));
        this.cardStack.push(new card("J", card.suit.SPADES));

        this.cardStack.push(new card("Q", card.suit.HEARTS));
        this.cardStack.push(new card("Q", card.suit.CLUBS));
        this.cardStack.push(new card("Q", card.suit.DIAMONDS));
        this.cardStack.push(new card("Q", card.suit.SPADES));

        this.cardStack.push(new card("K", card.suit.HEARTS));
        this.cardStack.push(new card("K", card.suit.CLUBS));
        this.cardStack.push(new card("K", card.suit.DIAMONDS));
        this.cardStack.push(new card("K", card.suit.SPADES));

        //Ace of hearts is first card (from layout creation)
        //this.cardStack.push(new card("A", card.suit.HEARTS));
        this.cardStack.push(new card("A", card.suit.CLUBS));
        this.cardStack.push(new card("A", card.suit.DIAMONDS));
        this.cardStack.push(new card("A", card.suit.SPADES));

        Collections.shuffle(this.cardStack);

    }

    public void changeCard(card c)
    {
        tv_upper.setText(c.getCardValue());
        tv_lower.setText(c.getCardValue());

        if (c.getSuit() == card.suit.SPADES)
        {
            iv_lower.setImageResource(R.drawable.spade);
            iv_upper.setImageResource(R.drawable.spade);
            iv_center.setImageResource(R.drawable.spade);
            tv_lower.setTextColor(Color.BLACK);
            tv_upper.setTextColor(Color.BLACK);

        }
        if (c.getSuit() == card.suit.CLUBS)
        {
            iv_lower.setImageResource(R.drawable.club);
            iv_center.setImageResource(R.drawable.club);
            iv_upper.setImageResource(R.drawable.club);
            tv_lower.setTextColor(Color.BLACK);
            tv_upper.setTextColor(Color.BLACK);


        }
        if (c.getSuit() == card.suit.HEARTS)
        {
            iv_lower.setImageResource(R.drawable.heart);
            iv_center.setImageResource(R.drawable.heart);
            iv_upper.setImageResource(R.drawable.heart);
            tv_lower.setTextColor(Color.RED);
            tv_upper.setTextColor(Color.RED);
        }
        if (c.getSuit() == card.suit.DIAMONDS)
        {
            iv_lower.setImageResource(R.drawable.diamond);
            iv_center.setImageResource(R.drawable.diamond);
            iv_upper.setImageResource(R.drawable.diamond);
            tv_lower.setTextColor(Color.RED);
            tv_upper.setTextColor(Color.RED);
        }
    }

    public void screenClick(View view) {

        if (!cardStack.isEmpty())
        {
            changeCard(cardStack.pop());
        }

        else
        {
            finish();
        }
    }
}
