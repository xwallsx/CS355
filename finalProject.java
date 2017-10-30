package com.example.matt.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
}

public void deathAwaits(View view) {
TextView text = (TextView) findViewById(R.id.textView);
EditText num = (EditText) findViewById(R.id.editText);
EditText num1 = (EditText) findViewById(R.id.editText2);
String word = text.getText().toString();
int number = Integer.parseInt(num.getText().toString());
int number2 = Integer.parseInt(num1.getText().toString());
String circle = buildCircle(word, number, number2);
text.setText(circle);
}

public String buildCircle(String word, Integer number, Integer number2) {
if(number<number2)
return "SIZE CANNOT BE GREATER THAN INCREMENTS!!";
Queue<Integer> queue = new LinkedList<>();
Queue<Integer> queue2 = new LinkedList<>();
Queue<Integer> n = new LinkedList<>();


int number3 = number2;
for (int i = 1; i <= number; i++) {
queue.add(i);

}

boolean q12q2=true;
int count2=0;

while (!(queue.size() ==1 && queue2.size() == 0) && !(queue.size() == 0 && queue2.size() ==1)) {
if (q12q2){
if (queue.size()>= number3|| count2>0) {
int count = 1+count2;
while (count < number3 && !queue.isEmpty()) {
queue2.add(queue.remove());
count++;
}
if (!queue.isEmpty()) {
Log.e("********DELETE1 ", n.add(queue.remove()) + "; " + queue.size() + "; " + queue.toString() + "; " + count2 + "; " + queue.size() + "; " + queue2.size() + queue2.toString());
count2 = 0;
}
}
else
{
count2 = 0;
while(!queue.isEmpty()) {
queue2.add(queue.remove());
count2++;
}
q12q2=false;
}

}
else
{
if (queue2.size()>= number3 || count2>0) {
int count = 1+count2;
while (count<number3 && !queue2.isEmpty()) {
queue.add(queue2.remove());
count ++;
}
if (!queue2.isEmpty()) {
Log.e("********DELETE2 ", n.add(queue2.remove()) + "; " + queue2.size() + "; " + queue2.toString() + "; " + count2 + "; " + queue.size() + "; " + queue2.size() + queue.toString());
count2 = 0;
}
}
else
{
q12q2=true;
count2=0;
while(!queue2.isEmpty()) {
queue.add(queue2.remove());
count2++;
}
}


}

}
String result;
if (queue.isEmpty())
result = "Gayle should avoid these spots "+ n.toString()+" and stay at " + queue2.toString();
else
result = "Gayle should avoid these spots "+ n.toString()+" and stay at " + queue.toString();
return result;
}

}
