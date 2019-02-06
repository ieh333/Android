package com.example.jana.transportationtask;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int[][] c = new int[3][4];
    int[][] x = new int[3][4];
    int[][] D = new int[3][4];
    int[] a = new int[3];
    int[] b = new int[4];
    int[] u = new int[3];
    int[] vv = new int[4];
    int[] s = new int[3];
    int[] t = new int[4];
    int count, max, max_index1, max_index2, index;
    int i, j, k, l;
    int Z = 0;
    String is_optimal;
    int sum_a, sum_b;
    boolean opt;
    private TextView txt2_1, txt3_1, txt4_1, txt5_1, txt6_1;
    private TextView txt1_2, txt1_3, txt1_4, txt1_5;
    private EditText edt2_2, edt3_2, edt4_2, edt5_2, edt6_2;
    private EditText edt2_3, edt3_3, edt4_3, edt5_3, edt6_3;
    private EditText edt2_4, edt3_4, edt4_4, edt5_4, edt6_4;
    private EditText edt2_5, edt3_5, edt4_5, edt5_5;
    private TextView txt6_5;
    private ImageView img1_1;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context context = getApplicationContext();
        img1_1 = (ImageView) findViewById(R.id.img1_1);
        txt2_1 = (TextView) findViewById(R.id.txt2_1);
        txt3_1 = (TextView) findViewById(R.id.txt3_1);
        txt4_1 = (TextView) findViewById(R.id.txt4_1);
        txt5_1 = (TextView) findViewById(R.id.txt5_1);
        txt6_1 = (TextView) findViewById(R.id.txt6_1);
        txt1_2 = (TextView) findViewById(R.id.txt1_2);
        txt1_3 = (TextView) findViewById(R.id.txt1_3);
        txt1_4 = (TextView) findViewById(R.id.txt1_4);
        txt1_5 = (TextView) findViewById(R.id.txt1_5);
        edt2_2 = (EditText) findViewById(R.id.edt2_2);
        edt3_2 = (EditText) findViewById(R.id.edt3_2);
        edt4_2 = (EditText) findViewById(R.id.edt4_2);
        edt5_2 = (EditText) findViewById(R.id.edt5_2);
        edt6_2 = (EditText) findViewById(R.id.edt6_2);
        edt2_3 = (EditText) findViewById(R.id.edt2_3);
        edt3_3 = (EditText) findViewById(R.id.edt3_3);
        edt4_3 = (EditText) findViewById(R.id.edt4_3);
        edt5_3 = (EditText) findViewById(R.id.edt5_3);
        edt6_3 = (EditText) findViewById(R.id.edt6_3);
        edt2_4 = (EditText) findViewById(R.id.edt2_4);
        edt3_4 = (EditText) findViewById(R.id.edt3_4);
        edt4_4 = (EditText) findViewById(R.id.edt4_4);
        edt5_4 = (EditText) findViewById(R.id.edt5_4);
        edt6_4 = (EditText) findViewById(R.id.edt6_4);
        edt2_5 = (EditText) findViewById(R.id.edt2_5);
        edt3_5 = (EditText) findViewById(R.id.edt3_5);
        edt4_5 = (EditText) findViewById(R.id.edt4_5);
        edt5_5 = (EditText) findViewById(R.id.edt5_5);
        txt6_5 = (TextView) findViewById(R.id.txt6_5);
        btn = (Button) findViewById(R.id.calculate);
        txt2_1.setText(Html.fromHtml("B<sub><small>1</small></sub>"));
        txt3_1.setText(Html.fromHtml("B<sub><small>2</small></sub>"));
        txt4_1.setText(Html.fromHtml("B<sub><small>3</small></sub>"));
        txt5_1.setText(Html.fromHtml("B<sub><small>4</small></sub>"));
        txt6_1.setText(Html.fromHtml("a<sub><small>i</small></sub>"));
        txt1_2.setText(Html.fromHtml("A<sub><small>1</small></sub>"));
        txt1_3.setText(Html.fromHtml("A<sub><small>2</small></sub>"));
        txt1_4.setText(Html.fromHtml("A<sub><small>3</small></sub>"));
        txt1_5.setText(Html.fromHtml("b<sub><small>j</small></sub>"));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c[0][0] = Integer.parseInt(edt2_2.getText().toString());
                c[0][1] = Integer.parseInt(edt3_2.getText().toString());
                c[0][2] = Integer.parseInt(edt4_2.getText().toString());
                c[0][3] = Integer.parseInt(edt5_2.getText().toString());
                c[1][0] = Integer.parseInt(edt2_3.getText().toString());
                c[1][1] = Integer.parseInt(edt3_3.getText().toString());
                c[1][2] = Integer.parseInt(edt4_3.getText().toString());
                c[1][3] = Integer.parseInt(edt5_3.getText().toString());
                c[2][0] = Integer.parseInt(edt2_4.getText().toString());
                c[2][1] = Integer.parseInt(edt3_4.getText().toString());
                c[2][2] = Integer.parseInt(edt4_4.getText().toString());
                c[2][3] = Integer.parseInt(edt5_4.getText().toString());
                a[0] = Integer.parseInt(edt6_2.getText().toString());
                a[1] = Integer.parseInt(edt6_3.getText().toString());
                a[2] = Integer.parseInt(edt6_4.getText().toString());
                b[0] = Integer.parseInt(edt2_5.getText().toString());
                b[1] = Integer.parseInt(edt3_5.getText().toString());
                b[2] = Integer.parseInt(edt4_5.getText().toString());
                b[3] = Integer.parseInt(edt5_5.getText().toString());
                sum_a = sum_b = 0;
                for (i = 0; i < a.length; i++) {
                    sum_a += a[i];
                }
                for (j = 0; j < b.length; j++) {
                    sum_b += b[j];
                }
                if (sum_a == sum_b) {
                    bdr();
                    target_function();
                    for (i = 0; i < 3; i++) {
                        s[i] = 0;
                    }
                    for (j = 0; j < 4; j++) {
                        t[j] = 0;
                    }
                    potentials();
                    opt = marks_index();
                    index = max_mark_index();
                    if (opt == true) {
                        is_optimal = "The solution is optimal!";
                    } else {
                        is_optimal = "The solution is not optimal!";
                    }
                }
                edt2_2.setText(String.valueOf(x[0][0]), TextView.BufferType.EDITABLE);
                edt2_2.setEnabled(false);
                edt2_2.setCursorVisible(false);
                edt2_2.setKeyListener(null);
                edt2_2.setBackgroundColor(Color.TRANSPARENT);
                edt3_2.setText(String.valueOf(x[0][1]), TextView.BufferType.EDITABLE);
                edt3_2.setEnabled(false);
                edt3_2.setCursorVisible(false);
                edt3_2.setKeyListener(null);
                edt3_2.setBackgroundColor(Color.TRANSPARENT);
                edt4_2.setText(String.valueOf(x[0][2]), TextView.BufferType.EDITABLE);
                edt4_2.setEnabled(false);
                edt4_2.setCursorVisible(false);
                edt4_2.setKeyListener(null);
                edt4_2.setBackgroundColor(Color.TRANSPARENT);
                edt5_2.setText(String.valueOf(x[0][3]), TextView.BufferType.EDITABLE);
                edt5_2.setEnabled(false);
                edt5_2.setCursorVisible(false);
                edt5_2.setKeyListener(null);
                edt5_2.setBackgroundColor(Color.TRANSPARENT);
                edt6_2.setEnabled(false);
                edt6_2.setCursorVisible(false);
                edt6_2.setKeyListener(null);
                edt6_2.setBackgroundColor(Color.TRANSPARENT);
                edt2_3.setText(String.valueOf(x[1][0]), TextView.BufferType.EDITABLE);
                edt2_3.setEnabled(false);
                edt2_3.setCursorVisible(false);
                edt2_3.setKeyListener(null);
                edt2_3.setBackgroundColor(Color.TRANSPARENT);
                edt3_3.setText(String.valueOf(x[1][1]), TextView.BufferType.EDITABLE);
                edt3_3.setEnabled(false);
                edt3_3.setCursorVisible(false);
                edt3_3.setKeyListener(null);
                edt3_3.setBackgroundColor(Color.TRANSPARENT);
                edt4_3.setText(String.valueOf(x[1][2]), TextView.BufferType.EDITABLE);
                edt4_3.setEnabled(false);
                edt4_3.setCursorVisible(false);
                edt4_3.setKeyListener(null);
                edt4_3.setBackgroundColor(Color.TRANSPARENT);
                edt5_3.setText(String.valueOf(x[1][3]), TextView.BufferType.EDITABLE);
                edt5_3.setEnabled(false);
                edt5_3.setCursorVisible(false);
                edt5_3.setKeyListener(null);
                edt5_3.setBackgroundColor(Color.TRANSPARENT);
                edt6_3.setEnabled(false);
                edt6_3.setCursorVisible(false);
                edt6_3.setKeyListener(null);
                edt6_3.setBackgroundColor(Color.TRANSPARENT);
                edt2_4.setText(String.valueOf(x[2][0]), TextView.BufferType.EDITABLE);
                edt2_4.setEnabled(false);
                edt2_4.setCursorVisible(false);
                edt2_4.setKeyListener(null);
                edt2_4.setBackgroundColor(Color.TRANSPARENT);
                edt3_4.setText(String.valueOf(x[2][1]), TextView.BufferType.EDITABLE);
                edt3_4.setEnabled(false);
                edt3_4.setCursorVisible(false);
                edt3_4.setKeyListener(null);
                edt3_4.setBackgroundColor(Color.TRANSPARENT);
                edt4_4.setText(String.valueOf(x[2][2]), TextView.BufferType.EDITABLE);
                edt4_4.setEnabled(false);
                edt4_4.setCursorVisible(false);
                edt4_4.setKeyListener(null);
                edt4_4.setBackgroundColor(Color.TRANSPARENT);
                edt5_4.setText(String.valueOf(x[2][3]), TextView.BufferType.EDITABLE);
                edt5_4.setEnabled(false);
                edt5_4.setCursorVisible(false);
                edt5_4.setKeyListener(null);
                edt5_4.setBackgroundColor(Color.TRANSPARENT);
                edt6_4.setEnabled(false);
                edt6_4.setCursorVisible(false);
                edt6_4.setKeyListener(null);
                edt6_4.setBackgroundColor(Color.TRANSPARENT);
                edt2_5.setEnabled(false);
                edt2_5.setCursorVisible(false);
                edt2_5.setKeyListener(null);
                edt2_5.setBackgroundColor(Color.TRANSPARENT);
                edt3_5.setEnabled(false);
                edt3_5.setCursorVisible(false);
                edt3_5.setKeyListener(null);
                edt3_5.setBackgroundColor(Color.TRANSPARENT);
                edt4_5.setEnabled(false);
                edt4_5.setCursorVisible(false);
                edt4_5.setKeyListener(null);
                edt4_5.setBackgroundColor(Color.TRANSPARENT);
                edt5_5.setEnabled(false);
                edt5_5.setCursorVisible(false);
                edt5_5.setKeyListener(null);
                edt5_5.setBackgroundColor(Color.TRANSPARENT);
                txt6_5.setText(String.valueOf(Z));
                Toast toast = Toast.makeText(context, is_optimal, Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

    private void bdr() {
        j = 0;
        for (i = 0; i < a.length; i++) {
            if (a[i] < b[j]) {
                x[i][j] = a[i];
                for (k = j + 1; k < b.length; k++) {
                    x[i][k] = 0;
                }
                b[j] = b[j] - a[i];
            } else if (a[i] > b[j]) {
                x[i][j] = b[j];
                for (l = i + 1; l < a.length; l++) {
                    x[l][j] = 0;
                }
                a[i] = a[i] - b[j];
                j++;
                i--;
            } else {
                x[i][j] = b[j];
                a[i] = a[i] - b[j];
                j++;
            }
        }
    }

    private void target_function() {
        for (i = 0; i < a.length; i++) {
            for (j = 0; j < b.length; j++) {
                if (x[i][j] != 0) {
                    Z += x[i][j] * c[i][j];
                } else {
                    continue;
                }
            }
        }
    }

    private void potentials() {
        count = 0;
        max = 0;
        max_index1 = max_index2 = 0;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 4; j++) {
                if (x[i][j] != 0) {
                    count++;
                } else {
                    continue;
                }
            }
            s[i] = count;
            count = 0;
        }
        for (j = 0; j < 4; j++) {
            for (i = 0; i < 3; i++) {
                if (x[i][j] != 0) {
                    count++;
                } else {
                    continue;
                }
            }
            t[j] = count;
            count = 0;
        }
        for (i = 0; i < 3; i++) {
            if (max < s[i]) {
                max = s[i];
                max_index1 = i;
            } else {
                continue;
            }
        }
        for (j = 0; j < 4; j++) {
            if (max < t[j]) {
                max = t[j];
                max_index2 = j;
            } else {
                continue;
            }
        }
        if (max_index1 > max_index2) {
            for (i = 0; i < 3; i++) {
                if (i == max_index1) {
                    u[i] = 1;
                } else {
                    continue;
                }
            }
        } else {
            for (j = 0; j < 4; j++) {
                if (j == max_index2) {
                    vv[j] = 1;
                } else {
                    continue;
                }
            }
        }
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 4; j++) {
                if (x[i][j] != 0) {
                    if (u[i] == 1) {
                        vv[j] = c[i][j] - u[i];
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        for (j = 0; j < 4; j++) {
            for (i = 0; i < 3; i++) {
                if (x[i][j] != 0) {
                    if (vv[j] != 0) {
                        u[i] = c[i][j] - vv[j];
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 4; j++) {
                if (x[i][j] != 0) {
                    if (u[i] != 0) {
                        vv[j] = c[i][j] - u[i];
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        for (j = 0; j < 4; j++) {
            for (i = 0; i < 3; i++) {
                if (x[i][j] != 0) {
                    if (vv[j] != 0) {
                        u[i] = c[i][j] - vv[j];
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
    }

    private boolean marks_index() {
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 4; j++) {
                if (x[i][j] == 0) {
                    D[i][j] = u[i] + vv[j] - c[i][j];
                } else {
                    continue;
                }
            }
        }
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 4; j++) {
                if (x[i][j] == 0) {
                    if (D[i][j] <= 0) {
                        continue;
                    } else {
                        return false;
                    }
                } else {
                    continue;
                }
            }
        }
        return true;
    }

    private int max_mark_index() {
        int max2 = 0;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 4; j++) {
                if (x[i][j] == 0) {
                    if (max2 < D[i][j]) {
                        max2 = D[i][j];
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        return max2;
    }
}