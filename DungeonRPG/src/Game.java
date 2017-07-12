import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Graphics;
public class Game extends JFrame implements KeyListener{

    //window vars
    private final int MAX_FPS;
    private final int WIDTH;
    private final int HEIGHT;

    //double buffer
    private BufferStrategy strategy;

    //loop variables
    private boolean isRunning = true;
    private long rest = 0;

    //timing variables
    private float dt;
    private long lastFrame;
    private long startFrame;
    private int fps;
    public boolean goup = false;
    public boolean godown = false;
    public boolean goleft = false;
    public boolean goright = false;
    public int move = 1;
    public int domove = 0;
    public int b_over = 20;
    public int b_up = 500;
    public int hp = 100;
    public int select = 0;
    public int click = 1;
    public String Player_name = "";
    public String Player_name2 = "";
    public int Name_length = 0;
    public String health = "";
    public int m_up = 397;
    int access = 0;
    Font font1 = new Font ("Levi Adobe Dia", Font.BOLD, 40);
    public enum game_state{
        menu,
        enter_name,
        play_game,
        end,
        encounter

    }
    game_state current_state = game_state.menu;

    //current_state = game_state(menu);

    //sprite1 variables
    private float x = 50;
    private float v = 10;

    //sprite2 variables
    private float x2 = 50.0f;
    private float v2 = 100.0f;


    private float wi = 280;
    private float wo = 380;

    private ArrayList<Integer> keys = new ArrayList<>();

    private void handlekeys(){
        for(int key : keys){
            switch(key){

            }
        }
    }

    public Game(int width, int height, int fps){
        super("JFrame Demo");
        this.MAX_FPS = fps;
        this.WIDTH = width;
        this.HEIGHT = height;
    }

    void init(){
        //initialize JFrame
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(0, 0, WIDTH, HEIGHT);

        setIgnoreRepaint(true);

        setResizable(false);
        setVisible(true);

        //create double buffer strategy
        createBufferStrategy(2);
        strategy = getBufferStrategy();

        lastFrame = System.currentTimeMillis();

        addKeyListener(this);
        setFocusable(true);
    }

    private void update() {
        //update current fps
        fps = (int) (1f / dt);
        handlekeys();

        //update sprite
        x += v;
        if (x < 50 || x > (WIDTH - 50)) v *= -1;

        x2 += v2 * dt;
        if (x2 < 50 || x2 > (WIDTH - 50)) v2 *= -1.0f;

        if (move == 1 && domove == 1 && wi != 25){
            wi = wi-5;
        }
        if (move == 2 && domove == 1 && wi != 560){
            wi = wi+5;
        }
        if (move == 3 && domove == 1 && wo != 0){
            wo = wo-5;
        }
        if (move == 4 && domove == 1 && wo != 760){
            wo = wo+5;
        }
        if(hp == 0){
            current_state = game_state.end;
        }
        if(select != 0){
            click = 0;
        }
        if(select == 0){
            click = 1;
        }
        if(current_state == game_state.menu && select == 1 &&  m_up == 397 && access == 0){
            access = 1;
            current_state = game_state.enter_name;
        }
        if(current_state == game_state.menu && select == 1 &&  m_up == 397 && access == 1){
            current_state = game_state.play_game;
        }
        if(current_state == game_state.menu && select == 1 &&  m_up == 500){
            System.exit(0);
        }
    }




    @Override
    public void keyTyped(KeyEvent keyEvent) {


    }

    public void keyPressed(KeyEvent w) {
        if(!keys.contains(w.getKeyCode()))
     keys.add(w.getKeyCode());

        switch (current_state) {

            case menu:
                if(click == 1) {
                    switch (w.getKeyCode()) {
                        case KeyEvent.VK_W:
                            m_up = 397;
                            break;
                        case KeyEvent.VK_S:
                            m_up = 500;
                            break;
                        case KeyEvent.VK_ENTER:
                            select = 10;
                            break;
                    }
                }
                break;
            case enter_name:
                if (Name_length != 10) {
                    switch (w.getKeyCode()) {
                        case KeyEvent.VK_A:
                            Player_name = Player_name + "A";
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_B:
                            Player_name = Player_name + "B";
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_C:
                            Player_name = Player_name + "C";
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_D:
                            Player_name = Player_name + "D";
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_E:
                            Player_name = Player_name + "E";
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_F:
                            Player_name = Player_name + "F";
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_G:
                            Player_name = Player_name + "G";
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_H:
                            Player_name = Player_name + "H";
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_I:
                            Player_name = Player_name + "I";
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_J:
                            Player_name = Player_name + "J";
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_K:
                            Player_name = Player_name + "K";
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_L:
                            Player_name = Player_name + "L";
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_M:
                            Player_name = Player_name + "M";
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_N:
                            Player_name = Player_name + "N";
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_O:
                            Player_name = Player_name + "O";
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_P:
                            Player_name = Player_name + "P";
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_Q:
                            Player_name = Player_name + "Q";
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_R:
                            Player_name = Player_name + "R";
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_S:
                            Player_name = Player_name + "S";
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_T:
                            Player_name = Player_name + "T";
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_U:
                            Player_name = Player_name + "U";
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_V:
                            Player_name = Player_name + "V";
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_W:
                            Player_name = Player_name + "W";
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_X:
                            Player_name = Player_name + "X";
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_Y:
                            Player_name = Player_name + "Y";
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_Z:
                            Player_name = Player_name + "Z";
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_BACK_SPACE:
                            Player_name = Player_name2;
                            Name_length = 0;
                            break;
                        case KeyEvent.VK_ENTER:
                            current_state = game_state.play_game;
                            break;
                    }
                }
                    switch (w.getKeyCode()){
                        case KeyEvent.VK_ENTER:
                            current_state = game_state.play_game;
                            break;
                        case KeyEvent.VK_BACK_SPACE:
                            Player_name = Player_name2;
                            Name_length = 0;
                            break;
                    }

                break;
            case play_game:
                switch (w.getKeyCode()) {

                case KeyEvent.VK_W:
                    move = 1;
                    domove = 1;
                    break;
                case KeyEvent.VK_S:
                    move = 2;
                    domove = 1;
                    break;
                case KeyEvent.VK_A:
                    move = 3;
                    domove = 1;
                    break;
                case KeyEvent.VK_D:
                    move = 4;
                    domove = 1;
                    break;
                    case KeyEvent.VK_MINUS:
                    current_state = game_state.encounter;
                    break;
                    case KeyEvent.VK_ESCAPE:
                        current_state = game_state.menu;
                        break;

                }
                break;
            case encounter:
                if(click == 1){
                switch (w.getKeyCode()) {
                    case KeyEvent.VK_W:
                        b_up = 500;
                        break;
                    case KeyEvent.VK_S:
                        b_up = 550;
                        break;
                    case KeyEvent.VK_A:
                        b_over = 20;
                        break;
                    case KeyEvent.VK_D:
                        b_over = 230;
                        break;
                    case KeyEvent.VK_ESCAPE:
                        current_state = game_state.play_game;
                        break;
                    case KeyEvent.VK_MINUS:
                        hp = hp - 1;
                        break;
                    case KeyEvent.VK_EQUALS:
                        if (hp != 100) {
                            hp = hp + 1;
                        }
                        break;
                    case KeyEvent.VK_ENTER:
                        select = 5;
                }
                }
                break;
            case end:
                switch (w.getKeyCode()){
                    case KeyEvent.VK_ENTER:
                    hp = 100;
                    Player_name = Player_name2;
                    current_state = game_state.menu;
                }
        }
    }
    @Override
    public void keyReleased(KeyEvent w) {
        switch (w.getKeyCode()) {
            case KeyEvent.VK_W:
                if (move == 1){
                    domove = 0;
        } break;
            case KeyEvent.VK_S:
                if (move == 2){
                    domove = 0;
                } break;
            case KeyEvent.VK_A:
                if (move == 3){
                    domove = 0;
                } break;
            case KeyEvent.VK_D:
                if (move == 4){
                    domove = 0;
                } break;
        }
    }
    private void draw(){

//get canvas
        Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
        switch(current_state){

            case menu:


            //clear screen
            g.setColor(Color.black);
            g.fillRect(0,0,WIDTH, HEIGHT);

            //draw fps
            g.setColor(Color.GREEN);
            g.drawString(Long.toString(fps), 10, 40);

            g.setColor(Color.GRAY);
            g.fillRect(200, 500, 400, 100 );

            g.setColor(Color.GRAY);
            g.fillRect(200, 397, 400, 100 );

                g.setFont(font1);
                g.setColor(Color.black);
                g.drawString("Play Game", 369, 450);

                g.setColor(Color.black);
                g.drawString("Quit", 386, 550);

                g.setColor(Color.red);
                g.fillRect(200,(int)m_up,20, 100);
                if(select > 0){
                    g.setColor(Color.white);
                    g.fillRect(200,(int)m_up,400, 100);
                    select = select-1;
                }
            break;
            case enter_name:
                g.setColor(Color.black);
                g.fillRect(0,0,WIDTH, HEIGHT);

                g.setColor(Color.gray);
                g.drawString("Enter Name:", 100, 100);

                g.setColor(Color.white);
                g.fillRect(180, 85, 200, 20);

                g.setColor(Color.black);
                g.drawString(Player_name, 180, 100);
                break;
            case play_game:

                //clear screen
                g.setColor(Color.black);
                g.fillRect(0,0,WIDTH, HEIGHT);

                //draw fps
                g.setColor(Color.GREEN);
                g.drawString(Long.toString(fps), 10, 40);

                g.setColor(Color.GRAY);
                g.fillRect( (int)wo, (int)wi, 40,40);
                break;
            case encounter:
                g.setColor(Color.black);
                g.fillRect(0,0,WIDTH, HEIGHT);

                //draw fps
                g.setColor(Color.GREEN);
                g.drawString(Long.toString(fps), 10, 40);

                g.setColor(Color.gray);
                g.fillRect(20,500,200, 40);

                g.setColor(Color.gray);
                g.fillRect(20,550,200, 40);

                g.setColor(Color.gray);
                g.fillRect(230,500,200, 40);

                g.setColor(Color.gray);
                g.fillRect(230,550,200, 40);

                g.setColor(Color.red);
                g.fillRect((int)b_over,(int)b_up,20, 40);
                if(select > 0){
                    g.setColor(Color.white);
                    g.fillRect((int)b_over,(int)b_up,200, 40);
                    select = select-1;

                }

                g.setColor(Color.white);
                g.fillRect(470,500,300, 30);

                g.setColor(Color.black);
                g.drawString(Player_name, 475, 520);

                if(hp >= 71) {
                    g.setColor(Color.green);
                }
                if(hp <= 70 && hp >= 31){
                    g.setColor(Color.yellow);
                }
                if(hp <= 30){
                    g.setColor(Color.red);
                }

                g.fillRect(560,504,(int)hp*2, 22);

                g.setColor(Color.black);
                g.drawString(Integer.toString(hp) + "/100", 650, 520);
                break;
            case end:
                g.setColor(Color.red);
                g.fillRect(0,0,WIDTH, HEIGHT);
                g.setColor(Color.black);
                g.drawString("DEATH", 400, 300);

        }

        //release resources, show the buffer
        g.dispose();
        strategy.show();
    }


    public void run(){
        init();

        while(isRunning){
            //new loop, clock the start
            startFrame = System.currentTimeMillis();
            //calculate delta time
            dt = (float)(startFrame - lastFrame)/1000;
            //log the current time
            lastFrame = startFrame;

            //call update and draw methods
            update();
            draw();

            //dynamic thread sleep, only sleep the time we need to cap the framerate
            rest = (1000/MAX_FPS) - (System.currentTimeMillis() - startFrame);
            if(rest >0){
                try{ Thread.sleep(rest); }
                catch (InterruptedException e){ e.printStackTrace(); }
            }
        }

    }


    public static void main(String[] args){
        Game game = new Game(800, 600, 60);
        game.run();
    }

}
