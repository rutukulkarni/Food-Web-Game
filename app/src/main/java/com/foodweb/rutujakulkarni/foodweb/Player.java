package com.IUB_SoftwareEngineering_Group1.FoodWeb;


import android.graphics.Bitmap;
import android.graphics.Canvas;


public class Player extends GameObject{
    private Bitmap spritesheet;
    private int score;
    private double dya;
    private boolean up;
    private boolean playing;
    private Animation animation = new Animation();
    private long startTime;
    public String playerType;

    public Player(Bitmap res, int w, int h, int numFrames, String pt) {

        x = 100;
        y = GamePanel.HEIGHT - 160;
        dy = 0;
        score = 0;
        height = h;
        width = w;
        playerType = pt;

        Bitmap[] image = new Bitmap[numFrames];
        spritesheet = res;

        for (int i = 0; i < image.length; i++)
        {
            image[i] = Bitmap.createBitmap(spritesheet, i*width, 0, width, height);
        }

        animation.setFrames(image);
        animation.setDelay(10);
        startTime = System.nanoTime();

    }

    public void setUp(boolean b){up = b;}

    public void update()
    {
        long elapsed = (System.nanoTime()-startTime)/1000000;
        if(elapsed>100)
        {
            score++;
            startTime = System.nanoTime();
        }
        animation.update();

        if(up){
        //            dy = (int)(dya-=1.1);
        //    dy = dy - 10;
            if(y>300)
            {
                y = y - 30;
            }


      //  y = y + 30;
        }
        else{

            if(y<(GamePanel.HEIGHT-160))
                {
                    y = y + 30;
                }

        }

       // if(dy>14)dy = 14;
       // if(dy<-14)dy = -14;
       // if(!(y>100 && y < (GamePanel.HEIGHT)-80))

         // y += dy;

      //  dy = 0;
    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(animation.getImage(),x,y,null);
    }
    public int getScore(){return score;}
    public boolean getPlaying(){return playing;}
    public void setPlaying(boolean b){playing = b;}
    public void resetDYA(){dya = 0;}
    public void resetScore(){score = 0;}
}

