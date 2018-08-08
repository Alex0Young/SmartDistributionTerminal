package com.example.alex.smartdistributionterminal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private TextView txt_right;
    private ImageView img_right;
    private ImageView[] imagebuttons;
    private TextView[] textViews;
   // private Fragment[] fragments;
   // public Fragment_Msg homefragment;
   // private Fragment_Friends contactlistfragment;
  //  private Fragment_Dicover findfragment;
  //  private Fragment_Profile profilefragment;
    private int index;
    private int currentintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviewbyid();
        initViews(); //初始化为 物流列表
        initTabView();  //初始化 按钮列表

    }

    private void initTabView(){
        imagebuttons = new ImageView[4];
        imagebuttons[0] = (ImageView) findViewById(R.id.ib_wuliu);
        imagebuttons[1] = (ImageView) findViewById(R.id.ib_chat_list);
        imagebuttons[2] = (ImageView) findViewById(R.id.ib_contacts);
        imagebuttons[3] = (ImageView) findViewById(R.id.ib_setting);

        imagebuttons[0].setSelected(true);

        textViews = new TextView[4];
        textViews[0] = (TextView) findViewById(R.id.tv_wuliu);
        textViews[1] = (TextView) findViewById(R.id.tv_chat_list);
        textViews[2] = (TextView) findViewById(R.id.tv_contacts);
        textViews[3] = (TextView) findViewById(R.id.tv_setting);

        textViews[0].setTextColor(0xff000000);
        // 添加显示第一个fragment
       /* getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, homefragment)
                .add(R.id.fragment_container, contactlistfragment)
                .add(R.id.fragment_container, profilefragment)
                .add(R.id.fragment_container, findfragment)
                .hide(contactlistfragment).hide(profilefragment)
                .hide(findfragment).show(homefragment).commit();
*/


    }

    public void onTabClicked(View view) {
        switch (view.getId()){
            case R.id.re_wuliu:
                Toast.makeText(this,"You clicked wuliu",Toast.LENGTH_SHORT).show();
                index = 0;
                break;
            case R.id.re_chat_list:
                Toast.makeText(this,"You clicked chat", Toast.LENGTH_SHORT).show();
                index = 1;
                break;
            case R.id.re_contacts:
                Toast.makeText(this,"contacts", Toast.LENGTH_SHORT).show();
                index = 2;
                break;
            case R.id.re_setting:
                Toast.makeText(this,"setting",Toast.LENGTH_SHORT).show();
                index = 3;
                break;
        }
        if(currentintent != index){
            //改为当前选择的Fragment
            Toast.makeText(this,"choose"+index, Toast.LENGTH_SHORT).show();
        }
        imagebuttons[currentintent].setSelected(false);
        // 把当前tab设为选中状态
        imagebuttons[index].setSelected(true);
        textViews[currentintent].setTextColor(0xffffffff);
        textViews[index].setTextColor(0xff000000);
        currentintent = index;
    }


    private void findviewbyid(){
        txt_right = (TextView) findViewById(R.id.txt_right);
        img_right = (ImageView) findViewById(R.id.img_right);
    }

    private void initViews() {
        // 设置消息页面为初始页面
        img_right.setVisibility(View.VISIBLE);
        img_right.setImageResource(R.drawable.saomiao);
    }
}
