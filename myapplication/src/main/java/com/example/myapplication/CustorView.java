package com.example.myapplication;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import java.util.ArrayList;
import java.util.List;


public class CustorView extends View {
    List<Bitmap> gradeBitmapList;

    public CustorView(Context context) {
        super(context);
        init(context, null);
    }

    public CustorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustorView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(context, attrs);
    }

    private Bitmap handBitmap;
    private Paint paint;
    private int width = 1080;
    private int heigh = 556;
    private int[] mMinColors = new int[]

            {
                    Color.parseColor("#FFB633"),
                    Color.parseColor("#FE7C2E")
            };

    private Rect srcRect = new Rect(0, 0, 90, 126);
    private RectF destRect = new RectF();
    List<String> gradeList = new ArrayList<>();
    private int grade = 0;
    Context context;
    private void init(Context context, AttributeSet attrs) {
        chageGradeX=false;
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setDither(true);
        gradeBitmapList = new ArrayList<>();
        gradeBitmapList.add(BitmapFactory.decodeResource(getResources(), R.mipmap.icon_yqc_upgrade_grade0));
        gradeBitmapList.add(BitmapFactory.decodeResource(getResources(), R.mipmap.icon_yqc_upgrade_grade1));
        gradeBitmapList.add(BitmapFactory.decodeResource(getResources(), R.mipmap.icon_yqc_upgrade_grade2));
        gradeBitmapList.add(BitmapFactory.decodeResource(getResources(), R.mipmap.icon_yqc_upgrade_grade3));
        gradeBitmapList.add(BitmapFactory.decodeResource(getResources(), R.mipmap.icon_yqc_upgrade_grade4));
        gradeBitmapList.add(BitmapFactory.decodeResource(getResources(), R.mipmap.icon_yqc_upgrade_grade5));

        gradeList.clear();
        gradeList.add("普通用户");
        gradeList.add("初级合伙人");
        gradeList.add("中级合伙人");
        gradeList.add("高级合伙人");
        gradeList.add("核心合伙人");
        gradeList.add("顶级合伙人");
        handBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.upgrade_btn_hand_icon);
        if (attrs == null) return;
        this.context=context;
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CustorView);
        grade = array.getInteger(R.styleable.CustorView_grade, 0);
        Log.e("CustorView", "grade1=" + grade);
        array.recycle();

        Log.e("CustorView", "grade2=" + grade);

    }

    private int getColor(int color) {
        return ContextCompat.getColor(getContext(), color);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        setMeasuredDimension(1080, 556);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case  MotionEvent.ACTION_DOWN:

                float dx=event.getX();
                float dy=event.getY();
                Log.e("CustorView", "点击="+ dx+","+dy);
                if(dy<409&&dy>0){
                    if(dx>72&&dx<(72+65)){//点击第0部分
                        Log.e("CustorView", "点击了第0部分");
                        changeGrade(0);

                    }else if(dx>246&&dx<(246+65)){//点击第1部分
                        Log.e("CustorView", "点击了第1部分");
                        changeGrade(1);

                    }else if(dx>420&&dx<(420+65)){//点击第2部分
                        Log.e("CustorView", "点击了第2部分");
                        changeGrade(2);

                    }else if(dx>593&&dx<(593+65)){//点击第3部分
                        Log.e("CustorView", "点击了第3部分");
                        changeGrade(3);

                    }else if(dx>768&&dx<(768+65)){//点击第4部分
                        Log.e("CustorView", "点击了第4部分");
                        changeGrade(4);
                    }else if(dx>942&&dx<(942+65)){//点击第5部分
                        Log.e("CustorView", "点击了第5部分");
                        changeGrade(5);
                    }
                }
                break;
            case MotionEvent.ACTION_MOVE://移动

                break;
        }
        return super.onTouchEvent(event);
    }
   private int endGradeX;
    private boolean chageGradeX=false;
    ValueAnimator valueAnimator=null;
    private void changeGrade(int now){
        if(grade!=now){
            chageGradeX=true;
            grade=now;
            setEndGradeX();
            if(valueAnimator!=null&&valueAnimator.isRunning()){
                valueAnimator.cancel();
            }
            valueAnimator= ValueAnimator.ofInt(px, endGradeX);
            valueAnimator.setDuration(500);
            valueAnimator.setInterpolator(new DecelerateInterpolator());
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {

                    // 当前的数值
                    int animatedValue = (int) valueAnimator.getAnimatedValue();
                    // 当前动画的进度
                    float animatedFraction = valueAnimator.getAnimatedFraction();

                    if(endGradeX!=px){

                        px=animatedValue;
                        invalidate();
                    }else{
                        chageGradeX=false;
                    }



                }
            });
            valueAnimator.start();
        }
    }

    private void setEndGradeX(){
        endGradeX=(109 + 65) * grade + 72 + 15;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(getColor(R.color.ho_line));
        //画横线
        canvas.drawRect(36, 405, 1044, 409, paint);


        //画柱状图0

        setGradien(72, 376, 137, 409, canvas);

        //画柱状图1

        setGradien(246, 347, 311, 409, canvas);

        //画柱状图2

        setGradien(420, 305, 485, 409, canvas);

        //画柱状图3

        setGradien(593, 278, 658, 409, canvas);

        //画柱状图4
        setGradien(768, 233, 833, 409, canvas);

        //画柱状图5
        setGradien(942, 197, 1007, 409, canvas);

        //画图片


        Bitmap bitmap = gradeBitmapList.get(0);
        destRect.set(63, 238, 149, 359);
        Log.e("CustorView", "图片宽高=" + bitmap.getWidth() + "," + bitmap.getHeight());
        srcRect.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawBitmap(gradeBitmapList.get(0), srcRect, destRect, paint);


        destRect.set(238, 190, 324, 311);
        canvas.drawBitmap(gradeBitmapList.get(1), srcRect, destRect, paint);


        destRect.set(410, 144, 496, 265);
        canvas.drawBitmap(gradeBitmapList.get(2), srcRect, destRect, paint);


        destRect.set(583, 109, 669, 230);
        canvas.drawBitmap(gradeBitmapList.get(3), srcRect, destRect, paint);


        destRect.set(757, 71, 843, 192);
        canvas.drawBitmap(gradeBitmapList.get(4), srcRect, destRect, paint);

        destRect.set(930, 27, 1016, 148);
        canvas.drawBitmap(gradeBitmapList.get(5), srcRect, destRect, paint);


        //画字

        paint.setTextSize(29);
        paint.setShader(null);//目标Paint即为绘制柱的Paint
        paint.setColor(getColor(R.color.app_save_money_pillars_text));
        canvas.drawText(gradeList.get(0), 45, 460, paint);

        canvas.drawText(gradeList.get(1), 204, 460, paint);


        canvas.drawText(gradeList.get(2), 377, 460, paint);


        canvas.drawText(gradeList.get(3), 552, 460, paint);


        canvas.drawText(gradeList.get(4), 724, 460, paint);


        canvas.drawText(gradeList.get(5), 896, 460, paint);


        drawGrade(canvas);

    }

    private int px=-1;
    private void drawGrade(Canvas canvas){
        //画图片

        srcRect.set(0, 0, handBitmap.getWidth(), handBitmap.getHeight());

        if(!chageGradeX){
            int x = (109 + 65) * grade + 72 + 15;
            //253, 477, 310, 534
            destRect.set(x, 477, x + 55, 534);
            canvas.drawBitmap(handBitmap, srcRect, destRect, paint);

            //当前等级
            paint.setTextSize(35);
            paint.setColor(getColor(R.color.ho_line_grade));

            canvas.drawText("当前等级", x + 57, 487 + 40, paint);
            px=x;
        }else{//执行动画
            //253, 477, 310, 534
            destRect.set(px, 477, px + 55, 534);
            canvas.drawBitmap(handBitmap, srcRect, destRect, paint);

            //当前等级
            paint.setTextSize(35);
            paint.setColor(getColor(R.color.ho_line_grade));

            canvas.drawText("当前等级", px + 57, 487 + 40, paint);


        }

    }



    /**
     * 设置渐变
     */
    private void setGradien(float x1, float y1, float x2, float y2, Canvas canvas) {
        //设置柱状图的颜色为渐变色
        LinearGradient linearGradient = new LinearGradient(x1, y1, x2, y2, mMinColors, null, Shader.TileMode.CLAMP);
        paint.setShader(linearGradient);//目标Paint即为绘制柱的Paint
        canvas.drawRect(x1, y1, x2, y2, paint);
    }
}
