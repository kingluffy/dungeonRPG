import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.WindowConstants;
import javax.imageio.ImageIO;
import java.awt.image.BufferStrategy;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
public class Game extends JFrame implements KeyListener{

    //window vars
    private int MAX_FPS;
    private int WIDTH;
    private int HEIGHT;
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
    public int hp = 50;
    public int select = 0;
    public int click = 1;
    public String Player_name = "";
    public String Player_name2 = "";
    public int Name_length = 0;
    public String health = "";
    public int m_up = 397;
    int access = 0;
    Font font1 = new Font ("Levi Adobe Dia", Font.BOLD, 10);
    Font font2 = new Font ("Levi Adobe Dia", Font.BOLD, 15);
    Font font3 = new Font ("Levi Adobe Dia", Font.BOLD, 20);
    Font font4 = new Font ("Levi Adobe Dia", Font.BOLD, 25);
    Font font5 = new Font ("Levi Adobe Dia", Font.BOLD, 30);
    Font font6 = new Font ("Levi Adobe Dia", Font.BOLD, 50);
    Font font7 = new Font ("Levi Adobe Dia", Font.BOLD, 100);
    Font font8 = new Font ("Levi Adobe Dia", Font.BOLD, 33);
    Font font9 = new Font ("Levi Adobe Dia", Font.BOLD, 40);
    public int b_but = 1;
    public int upppercase = 0;
    public int show_menu = 0;
    public int r_heal = 5;
    public int b_heal = 2;
    public int g_heal = 1;
    public int heal = 0;
    public int i_over = 15;
    public int i_up = 0;
    public int blink = 0;
    public int i_back = 0;
    public int walk_on = 0;
    public int debug = 0;
    public int gold = 0;
    public int bugde = 40;
    public BufferedImage hair;
    public BufferedImage g_hair;
    public BufferedImage slime;
    public BufferedImage dontsuemesaur;
    public BufferedImage anthrax;
    public int head = 0;
    public int head_change = 0;
    public int e_up1 = 350;
    public int e_over1 = 180;
    public int e_up2 = 260;
    public int e_over2 = 560;
    public int e_up3 = 90;
    public int e_over3 = 200;
    public int e1 = 0;
    public int e2 = 0;
    public int e3 = 0;
    public int e_move1 = 0;
    public int e_move2 = 0;
    public int e_move3 = 0;
    public int encounter = 0;
    public int e_hp = 0;
    public int fe_hp = 0;
    public int atkl = 3;
    public int atkh = 8;
    public int attack = 0;
    public int def = 0;
    public int e_def;
    public int xp = 0;
    public int despawn1 = 0;
    public int despawn2 = 0;
    public int despawn3 = 0;
    public int turn = 1;
    public int e_attack = 0;
    public int b_lag = 0;
    public int lvl = 1;
    public int lvlxp = 20;
    public int addxp = 0;
    public int addgold = 0;
    public int addatk = 0;
    public int fhp = 50;
    public int menwait = 0;
    public int pause = 0;
    public int openshop = 0;
    public int m_item = 1;
    public int menu_up = 170;
    public int spawntime = 500;
    public int m_up2 = 0;
    public int msl = 100;
    public int m_back = 0;
    public int xp_mult = 1;
    public int gold_mult = 1;
    public int d_buy = 0;
    public int a_buy = 0;
    public int dprice = 300;
    public int aprice = 400;
    public int vanilla_bean_coolata = 0;
    public int buy4 = 0;
    public int buy7 = 0;
    public int buy8 = 0;
    public int buy10 = 0;
    public int nogold = 1;
    public enum room{
        shop,
        dungeon1,
        upgrades,
        dungeon2,
        skills,
        boss

    }
    room current_room = room.shop;
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


    private int wi = 280;
    private int wo = 380;

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
        try{
            hair = ImageIO.read(new File("super_hair.png"));
            g_hair = ImageIO.read(new File("goku_hair.png"));
            slime = ImageIO.read(new File("slime.png"));
            dontsuemesaur = ImageIO.read(new File("Humungousaur.png"));
            anthrax = ImageIO.read(new File("anthrax.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
        repaint();
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
            if(walk_on == 0){
                wi = wi-4;
            }
            wi = wi-1;
        }
        if (move == 2 && domove == 1 && wi != 560){
            if(walk_on == 0){
                wi = wi+4;
            }
            wi = wi+1;
        }
        if (move == 3 && domove == 1 && wo != 0){
            if(walk_on == 0){
                wo = wo-4;
            }
            wo = wo-1;
        }
        if (move == 4 && domove == 1 && wo != 760){
            if(walk_on == 0){
                wo = wo+4;
            }
            wo = wo+1;
        }
        if(hp == 0 || hp < 0){
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
        if(b_up == 500 && b_over == 20){
            b_but = 1;
        }
        if(b_up == 550 && b_over == 20){
            b_but = 2;
        }
        if(b_up == 500 && b_over == 230){
            b_but = 3;
        }
        if(b_up == 550 && b_over == 230){
            b_but = 4;
        }
        if(current_state == game_state.encounter && select == 1 &&  b_but == 1){
            attack = ThreadLocalRandom.current().nextInt(atkl, atkh + 1);
            if(e_def >= attack){
                e_hp = e_hp - 1;
            }else {
                e_hp = e_hp - (attack - e_def);
            }
            select = 0;
            b_lag = 30;
            turn = 2;
        }
        if(current_state == game_state.encounter && select == 1 &&  b_but == 4){
            current_state = game_state.play_game;
            b_but = 1;
            b_up = 500;
            b_over = 20;
            select = 0;
        }
        if(current_state == game_state.encounter && select == 1 &&  b_but == 2){
            select = 0;
            i_up = 0;
            i_over = 15;
            show_menu = 1;
        }
        if(current_state == game_state.play_game && show_menu == 1){
            switch(i_up){
                case 240:
                    heal = 1;
                    break;
                case 280:
                    heal = 2;
                    break;
                case 320:
                    heal = 3;
                    break;
            }
        }

        if(show_menu == 1 && blink == 1 && heal == 1 && r_heal != 0){
            select = 0;
            blink = 0;
            heal = 0;
            hp = hp + 20;
            if(hp > fhp){
                hp = fhp;
            }
            r_heal = r_heal - 1;
        }
        if(show_menu == 1 && blink == 1 && heal == 2 && b_heal != 0){
            select = 0;
            blink = 0;
            heal = 0;
            hp = hp + 50;
            if(hp > fhp){
                hp = fhp;
            }
            b_heal = b_heal - 1;
        }
        if(show_menu == 1 && blink == 1 && heal == 3 && g_heal != 0){
            select = 0;
            blink = 0;
            heal = 0;
            hp = hp +80;
            if(hp > fhp){
                hp = fhp;
            }
            g_heal = g_heal - 1;
        }
        if(show_menu == 1 && blink == 1 && i_back == 1) {
            select = 0;
            blink = 0;
            i_up = 0;
            i_back = 0;
            show_menu = 0;
        }
        switch(current_state) {
            case play_game:
                switch (current_room) {
                    case shop:
                        if (despawn1 != 0) {
                            despawn1 = despawn1 - 2;
                        }
                        if (despawn3 != 0) {
                            despawn3 = despawn3 - 2;
                        }
                        if (despawn2 != 0) {
                            despawn2 = despawn2 - 2;
                        }
                        break;
                    case dungeon1:
                    if (despawn1 != 0) {
                        despawn1 = despawn1 - 1;
                    }
                    if (despawn3 != 0) {
                        despawn3 = despawn3 - 1;
                    }
                    if (despawn2 != 0) {
                        despawn2 = despawn2 - 1;
                    }
                    break;
                }
                if(despawn1 == 1 ||despawn1 == 2 ){
                    despawn1 = 0;
                    e_move1 = 30;
                    e_up1 = 350;
                    e_over1 = 180;
                }
                if(despawn2 == 1 || despawn2 == 2){
                    despawn2 = 0;
                    e_move2 = 45;
                    e_up2 = 260;
                    e_over2 = 560;
                }
                if(despawn3 == 1 || despawn3 == 2){
                    despawn3 = 0;
                    e_move3 = 25;
                    e_up3 = 90;
                    e_over3 = 200;
                }

                switch (current_room) {
                    case shop:
                        if (445 > wo && wo > 305 && 160 > wi && wi > 60) {
                            openshop = 1;
                            switch (move) {
                                case 1:
                                    wi = 160;
                                    openshop = 1;
                                    break;
                                case 2:
                                    wi = 60;
                                    openshop = 1;
                                    break;
                                case 3:
                                    wo = 445;
                                    openshop = 1;
                                    break;
                                case 4:
                                    wo = 305;
                                    openshop = 1;
                                    break;
                            }
                        }
                        if(openshop == 1){
                            move = 0;
                            m_item = 1;
                            show_menu = 4;
                            domove = 0;
                            m_up2 = 170;
                            menu_up = 170;
                            i_over = 228;
                            pause = 1;
                            select = 0;
                            openshop = 0;
                        }
                        dprice = 300 + (400 * d_buy);
                        aprice = 400 + (400 * a_buy);
                        if(menu_up == 165){
                            m_back = 1;
                        }else{
                            m_back = 0;
                        }
                        if(show_menu == 4 && blink == 1){
                            if(m_back == 1){
                                menu_up = 0;
                                blink = 0;
                                m_back = 0;
                                select = 0;
                                show_menu = 0;
                                pause = 0;
                                domove = 1;
                            }
                            switch(m_item){
                                case 1:
                                    if(gold >= 30){
                                        gold = gold - 30;
                                        r_heal = r_heal + 1;
                                        blink = 0;
                                        nogold = 0;
                                    }else{
                                        nogold = 1;
                                    }
                                    break;
                                case 2:
                                    if(gold >= 80){
                                        gold = gold - 80;
                                        b_heal = b_heal + 1;
                                        blink = 0;
                                        nogold = 0;
                                    }else{
                                        nogold = 1;
                                    }
                                    break;
                                case 3:
                                    if(gold >= 150){
                                        gold = gold - 150;
                                        g_heal = g_heal + 1;
                                        blink = 0;
                                        nogold = 0;
                                    }else{
                                        nogold = 1;
                                    }
                                    break;
                                case 4:
                                    if(gold >= 1500 && buy4 == 0){
                                        gold = gold - 1500;
                                        xp_mult = 2;
                                        buy4 = 1;
                                        blink = 0;
                                        nogold = 0;
                                    }else{
                                        nogold = 1;
                                    }
                                    break;
                                case 5:
                                    if(gold >= dprice){
                                        gold = gold - dprice;
                                        def = def + 1;
                                        d_buy = d_buy + 1;
                                        blink = 0;
                                        nogold = 0;
                                    }else{
                                        nogold = 1;
                                    }
                                    break;
                                case 6:
                                    if(gold >= aprice){
                                        gold = gold - aprice;
                                        atkh = atkh + 1;
                                        atkl = atkl + 1;
                                        a_buy = a_buy + 1;
                                        blink = 0;
                                        nogold = 0;
                                    }else{
                                        nogold = 1;
                                    }
                                    break;
                                case 7:
                                    if(gold >= 5000 && buy7 == 0 && lvl >= 15){
                                        gold = gold - 5000;
                                        vanilla_bean_coolata = 1;
                                        buy7 = 1;
                                        blink = 0;
                                        nogold = 0;
                                    }else{
                                        nogold = 1;
                                    }
                                    break;
                                case 8:
                                    if(gold >= 1000 && buy8 == 0){
                                        gold = gold - 1000;
                                        spawntime = 250;
                                        buy8 = 1;
                                        blink = 0;
                                        nogold = 0;
                                    }else{
                                        nogold = 1;
                                    }
                                    break;
                                case 9:
                                    if(gold >= 200){
                                        gold = gold - 200;
                                        hp = fhp;
                                        blink = 0;
                                        nogold = 0;
                                    }else{
                                        nogold = 1;
                                    }
                                    break;
                                case 10:
                                    if(gold >= 2000 && buy10 == 0){
                                        gold = gold - 2000;
                                        gold_mult = 2;
                                        buy10 = 1;
                                        blink = 0;
                                        nogold = 0;
                                    }else{
                                        nogold = 1;
                                    }
                                    break;
                            }
                            blink = 0;
                        }
                        if (350 > wo && wo > 60 && 520 > wi && wi > 480) {
                            switch (move) {
                                case 1:
                                    break;
                                case 2:
                                    wi = 480;
                                    break;
                                case 3:
                                    wo = 350;
                                    break;
                                case 4:
                                    break;
                            }
                        }
                        if (70 > wo && wo > 20 && 520 > wi && wi > 40) {
                            switch (move) {
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    wo = 70;
                                    break;
                                case 4:
                                    break;
                            }
                        }
                        if (700 > wo && wo > 50 && 60 > wi && wi > 50) {
                            switch (move) {
                                case 1:
                                    wi = 60;
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                            }
                        }
                        if (740 > wo && wo > 690 && 530 > wi && wi > 50) {
                            switch (move) {
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    wo = 690;
                                    break;
                            }
                        }
                        if (740 > wo && wo > 410 && 530 > wi && wi > 480) {
                            switch (move) {
                                case 1:
                                    break;
                                case 2:
                                    wi = 480;
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    wo = 410;
                                    break;
                            }
                        }
                        if (420 > wo && wo > 340 && 525 > wi && wi > 485) {
                            current_room = room.dungeon1;
                            wo = 380;
                            wi = 55;
                        }
                        break;
                    case dungeon1:
                        if (740 > wo && wo > 60 && 520 > wi && wi > 480) {
                            switch (move) {
                                case 1:
                                    break;
                                case 2:
                                    wi = 480;
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                            }
                        }
                        if (70 > wo && wo > 20 && 520 > wi && wi > 40) {
                            switch (move) {
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    wo = 70;
                                    break;
                                case 4:
                                    break;
                            }
                        }
                        if (740 > wo && wo > 410 && 60 > wi && wi > 50) {
                            switch (move) {
                                case 1:
                                    wi = 60;
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    wo = 410;
                                    break;
                            }
                        }
                        if (740 > wo && wo > 690 && 530 > wi && wi > 50) {
                            switch (move) {
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    wo = 690;
                                    break;
                            }
                        }
                        if (740 > wo && wo > 410 && 530 > wi && wi > 480) {
                            switch (move) {
                                case 1:
                                    break;
                                case 2:
                                    wi = 480;
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    wo = 410;
                                    break;
                            }
                        }
                        if (350 > wo && wo > 60 && 60 > wi && wi > 50) {
                            switch (move) {
                                case 1:
                                    wi = 60;
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    wo = 350;
                                    break;
                                case 4:
                                    break;
                            }
                        }
                        if (415 > wo && wo > 345 && 55 > wi && wi > 30) {
                            current_room = room.shop;
                            wo = 380;
                            wi = 485;
                        }
                        if (e_move1 == 0) {
                            e1 = ThreadLocalRandom.current().nextInt(1, 5);
                            e_move1 = 110;
                        }
                        if (e_move2 == 0) {
                            e2 = ThreadLocalRandom.current().nextInt(1, 5);
                            e_move2 = 120;
                        }
                        if (e_move3 == 0) {
                            e3 = ThreadLocalRandom.current().nextInt(1, 5);
                            e_move3 = 115;
                        }
                        if(pause != 1) {
                            e_move1 = e_move1 - 1;
                            e_move2 = e_move2 - 1;
                            e_move3 = e_move3 - 1;
                        }
                        if(pause != 1) {
                            if (e_move1 < 30) {
                                switch (e1) {
                                    case 1:
                                        e_up1 = e_up1 - 1;
                                        break;
                                    case 2:
                                        e_up1 = e_up1 + 1;
                                        break;
                                    case 3:
                                        e_over1 = e_over1 - 1;
                                        break;
                                    case 4:
                                        e_over1 = e_over1 + 1;
                                        break;
                                }
                            }
                            if (e_move2 < 40) {
                                switch (e2) {
                                    case 1:
                                        e_up2 = e_up2 - 1;
                                        break;
                                    case 2:
                                        e_up2 = e_up2 + 1;
                                        break;
                                    case 3:
                                        e_over2 = e_over2 - 1;
                                        break;
                                    case 4:
                                        e_over2 = e_over2 + 1;
                                        break;
                                }
                            }
                            if (e_move3 < 25) {
                                switch (e3) {
                                    case 1:
                                        e_up3 = e_up3 - 1;
                                        break;
                                    case 2:
                                        e_up3 = e_up3 + 1;
                                        break;
                                    case 3:
                                        e_over3 = e_over3 - 1;
                                        break;
                                    case 4:
                                        e_over3 = e_over3 + 1;
                                        break;
                                }
                            }
                        }
                        if ((e_over1 + 30) > wo && wo > (e_over1 - 40) && (e_up1 + 30) > wi && wi > (e_up1 - 40)) {
                            domove = 0;
                            switch (move) {
                                case 1:
                                    wi = wi + 10;
                                    break;
                                case 2:
                                    wi = wi - 10;
                                    break;
                                case 3:
                                    wo = wo + 10;
                                    break;
                                case 4:
                                    wo = wo - 10;
                                    break;
                            }
                            encounter = 1;
                            e_hp = ThreadLocalRandom.current().nextInt(60, 90 + 1);
                            e_def = ThreadLocalRandom.current().nextInt(5, 9 + 1);
                            fe_hp = e_hp;
                            current_state = game_state.encounter;
                        }
                        if ((e_over2 + 30) > wo && wo > (e_over2 - 40) && (e_up2 + 30) > wi && wi > (e_up2 - 40)) {
                            domove = 0;
                            switch (move) {
                                case 1:
                                    wi = wi + 10;
                                    break;
                                case 2:
                                    wi = wi - 10;
                                    break;
                                case 3:
                                    wo = wo + 10;
                                    break;
                                case 4:
                                    wo = wo - 10;
                                    break;
                            }
                            encounter = 2;
                            e_hp = ThreadLocalRandom.current().nextInt(30, 60 + 1);
                            e_def = ThreadLocalRandom.current().nextInt(2, 5 + 1);
                            fe_hp = e_hp;
                            current_state = game_state.encounter;
                        }
                        if ((e_over3 + 30) > wo && wo > (e_over3 - 40) && (e_up3 + 30) > wi && wi > (e_up3 - 40)) {
                            domove = 0;
                            switch (move) {
                                case 1:
                                    wi = wi + 10;
                                    break;
                                case 2:
                                    wi = wi - 10;
                                    break;
                                case 3:
                                    wo = wo + 10;
                                    break;
                                case 4:
                                    wo = wo - 10;
                                    break;
                            }
                            encounter = 3;
                            e_hp = ThreadLocalRandom.current().nextInt(15, 30 + 1);
                            e_def = ThreadLocalRandom.current().nextInt(0, 2 + 1);
                            fe_hp = e_hp;
                            current_state = game_state.encounter;
                        }
                        //enemy1
                        if (740 > e_over1 && e_over1 > 60 && 520 > e_up1 && e_up1 > 490) {
                            switch (e1) {
                                case 1:
                                    break;
                                case 2:
                                    e_up1 = 490;
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                            }
                        }
                        if (70 > e_over1 && e_over1 > 20 && 520 > e_up1 && e_up1 > 40) {
                            switch (e1) {
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    e_over1 = 70;
                                    break;
                                case 4:
                                    break;
                            }
                        }
                        if (740 > e_over1 && e_over1 > 60 && 60 > e_up1 && e_up1 > 50) {
                            switch (e1) {
                                case 1:
                                    e_up1 = 60;
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    e_over1 = 410;
                                    break;
                            }
                        }
                        if (350 > e_over1 && e_over1 > 60 && 60 > e_up1 && e_up1 > 50) {
                            switch (e1) {
                                case 1:
                                    e_up1 = 60;
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    e_over1 = 350;
                                    break;
                                case 4:
                                    break;
                            }
                        }
                        if (740 > e_over1 && e_over1 > 690 && 530 > e_up1 && e_up1 > 50) {
                            switch (e1) {
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    e_over1 = 690;
                                    break;
                            }
                        }
                        //enemy2
                        if (740 > e_over2 && e_over2 > 60 && 520 > e_up2 && e_up2 > 490) {
                            switch (e2) {
                                case 1:
                                    break;
                                case 2:
                                    e_up2 = 490;
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                            }
                        }
                        if (70 > e_over2 && e_over2 > 20 && 520 > e_up2 && e_up2 > 40) {
                            switch (e2) {
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    e_over2 = 70;
                                    break;
                                case 4:
                                    break;
                            }
                        }
                        if (740 > e_over2 && e_over2 > 60 && 60 > e_up2 && e_up2 > 50) {
                            switch (e2) {
                                case 1:
                                    e_up2 = 60;
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    e_over2 = 410;
                                    break;
                            }
                        }
                        if (350 > e_over2 && e_over2 > 60 && 60 > e_up2 && e_up2 > 50) {
                            switch (e2) {
                                case 1:
                                    e_up2 = 60;
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    e_over2 = 350;
                                    break;
                                case 4:
                                    break;
                            }
                        }
                        if (740 > e_over2 && e_over2 > 690 && 530 > e_up2 && e_up2 > 50) {
                            switch (e2) {
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    e_over2 = 690;
                                    break;
                            }
                        }
                        //enemy3
                        if (740 > e_over3 && e_over3 > 60 && 520 > e_up3 && e_up3 > 490) {
                            switch (e3) {
                                case 1:
                                    break;
                                case 2:
                                    e_up3 = 490;
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                            }
                        }
                        if (70 > e_over3 && e_over3 > 20 && 520 > e_up3 && e_up3 > 40) {
                            switch (e3) {
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    e_over3 = 70;
                                    break;
                                case 4:
                                    break;
                            }
                        }
                        if (740 > e_over3 && e_over3 > 60 && 60 > e_up3 && e_up3 > 50) {
                            switch (e3) {
                                case 1:
                                    e_up3 = 60;
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    e_over3 = 410;
                                    break;
                            }
                        }
                        if (350 > e_over3 && e_over3 > 60 && 60 > e_up3 && e_up3 > 50) {
                            switch (e2) {
                                case 1:
                                    e_up3 = 60;
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    e_over3 = 350;
                                    break;
                                case 4:
                                    break;
                            }
                        }
                        if (740 > e_over3 && e_over3 > 690 && 530 > e_up3 && e_up3 > 50) {
                            switch (e3) {
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    e_over3 = 690;
                                    break;
                            }
                        }
                }
                break;
            case encounter:
                if (turn == 2){
                    click = 0;
                    if(b_lag == 0) {
                        switch (encounter) {
                            case 1:
                                e_attack = ThreadLocalRandom.current().nextInt(9, 13 + 1);
                                if(e_attack < def){
                                    hp = hp - 1;
                                }else{
                                    hp = (hp - (e_attack - def));
                                }
                                turn = 1;
                                break;
                            case 2:
                                e_attack = ThreadLocalRandom.current().nextInt(4, 8 + 1);
                                if(e_attack < def){
                                    hp = hp - 1;
                                }else{
                                    hp = (hp - (e_attack - def));
                                }
                                turn = 1;
                                break;
                            case 3:
                                e_attack = ThreadLocalRandom.current().nextInt(1, 5 + 1);
                                if(e_attack < def){
                                 hp = hp - 1;
                                }else{
                                        hp = (hp - (e_attack - def));
                                }
                                turn = 1;
                                break;
                        }
                    }
                    if(b_lag != 0){
                     b_lag = b_lag - 1;
                    }
                }
                if(turn == 1){
                    click = 1;
                }
                if(e_hp <= 0 && show_menu != 2 && show_menu != 3){
                    switch (encounter) {
                        case 1:
                            turn = 0;
                            e_hp = 0;
                            despawn1 = spawntime;
                            e_up1 = 9000;
                            e_over1 = 9000;
                            addgold = ThreadLocalRandom.current().nextInt(50, 100 + 1);
                            addxp = ThreadLocalRandom.current().nextInt(80, 100);
                            gold = gold + (addgold * gold_mult);
                            xp = xp + (addxp * xp_mult);
                            show_menu = 2;
                            break;
                        case 2:
                            turn = 0;
                            e_hp = 0;
                            despawn2 = spawntime;
                            e_up2 = 9000;
                            e_over2 = 9000;
                            addgold = ThreadLocalRandom.current().nextInt(30, 80 + 1);
                            addxp = ThreadLocalRandom.current().nextInt(20, 50);
                            gold = gold + (addgold * gold_mult);
                            xp = xp + (addxp * xp_mult);
                            show_menu = 2;
                            break;
                        case 3:
                            turn = 0;
                            e_hp = 0;
                            despawn3 = spawntime;
                            e_up3 = 9000;
                            e_over3 = 9000;
                            addgold = ThreadLocalRandom.current().nextInt(5, 10 + 1);
                            addxp = ThreadLocalRandom.current().nextInt(5, 10);
                            gold = gold + (addgold * gold_mult);
                            xp = xp + (addxp * xp_mult);
                            show_menu = 2;
                            break;
                    }
                }
                break;
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
                            select = 5;
                            break;
                        case KeyEvent.VK_V:
                            debug = 1;
                            break;
                    }
                }
                break;
            case enter_name:
                if (Name_length != 10) {
                    switch (w.getKeyCode()) {
                        case KeyEvent.VK_SHIFT:
                            upppercase = 1;
                            break;
                        case KeyEvent.VK_A:
                            if(upppercase == 1){
                                Player_name = Player_name + "A";
                            }
                            if(upppercase == 0){
                                Player_name = Player_name + "a";
                            }
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_B:
                            if(upppercase == 1){
                                Player_name = Player_name + "B";
                            }
                            if(upppercase == 0){
                                Player_name = Player_name + "b";
                            }
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_C:
                            if(upppercase == 1){
                                Player_name = Player_name + "C";
                            }
                            if(upppercase == 0){
                                Player_name = Player_name + "c";
                            }
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_D:
                            if(upppercase == 1){
                                Player_name = Player_name + "D";
                            }
                            if(upppercase == 0){
                                Player_name = Player_name + "d";
                            }
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_E:
                            if(upppercase == 1){
                                Player_name = Player_name + "E";
                            }
                            if(upppercase == 0){
                                Player_name = Player_name + "e";
                            }
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_F:
                            if(upppercase == 1){
                                Player_name = Player_name + "F";
                            }
                            if(upppercase == 0){
                                Player_name = Player_name + "f";
                            }
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_G:
                            if(upppercase == 1){
                                Player_name = Player_name + "G";
                            }
                            if(upppercase == 0){
                                Player_name = Player_name + "g";
                            }
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_H:
                            if(upppercase == 1){
                                Player_name = Player_name + "H";
                            }
                            if(upppercase == 0){
                                Player_name = Player_name + "h";
                            }
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_I:
                            if(upppercase == 1){
                                Player_name = Player_name + "I";
                            }
                            if(upppercase == 0){
                                Player_name = Player_name + "i";
                            }
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_J:
                            if(upppercase == 1){
                                Player_name = Player_name + "J";
                            }
                            if(upppercase == 0){
                                Player_name = Player_name + "j";
                            }
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_K:
                            if(upppercase == 1){
                                Player_name = Player_name + "K";
                            }
                            if(upppercase == 0){
                                Player_name = Player_name + "k";
                            }
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_L:
                            if(upppercase == 1){
                                Player_name = Player_name + "L";
                            }
                            if(upppercase == 0){
                                Player_name = Player_name + "l";
                            }
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_M:
                            if(upppercase == 1){
                                Player_name = Player_name + "M";
                            }
                            if(upppercase == 0){
                                Player_name = Player_name + "m";
                            }
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_N:
                            if(upppercase == 1){
                                Player_name = Player_name + "N";
                            }
                            if(upppercase == 0){
                                Player_name = Player_name + "n";
                            }
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_O:
                            if(upppercase == 1){
                                Player_name = Player_name + "O";
                            }
                            if(upppercase == 0){
                                Player_name = Player_name + "o";
                            }
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_P:
                            if(upppercase == 1){
                                Player_name = Player_name + "P";
                            }
                            if(upppercase == 0){
                                Player_name = Player_name + "p";
                            }
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_Q:
                            if(upppercase == 1){
                                Player_name = Player_name + "Q";
                            }
                            if(upppercase == 0){
                                Player_name = Player_name + "q";
                            }
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_R:
                            if(upppercase == 1){
                                Player_name = Player_name + "R";
                            }
                            if(upppercase == 0){
                                Player_name = Player_name + "r";
                            }
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_S:
                            if(upppercase == 1){
                                Player_name = Player_name + "S";
                            }
                            if(upppercase == 0){
                                Player_name = Player_name + "s";
                            }
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_T:
                            if(upppercase == 1){
                                Player_name = Player_name + "T";
                            }
                            if(upppercase == 0){
                                Player_name = Player_name + "t";
                            }
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_U:
                            if(upppercase == 1){
                                Player_name = Player_name + "U";
                            }
                            if(upppercase == 0){
                                Player_name = Player_name + "u";
                            }
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_V:
                            if(upppercase == 1){
                                Player_name = Player_name + "V";
                            }
                            if(upppercase == 0){
                                Player_name = Player_name + "v";
                            }
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_W:
                            if(upppercase == 1){
                                Player_name = Player_name + "W";
                            }
                            if(upppercase == 0){
                                Player_name = Player_name + "w";
                            }
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_X:
                            if(upppercase == 1){
                                Player_name = Player_name + "X";
                            }
                            if(upppercase == 0){
                                Player_name = Player_name + "x";
                            }
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_Y:
                            if(upppercase == 1){
                                Player_name = Player_name + "Y";
                            }
                            if(upppercase == 0){
                                Player_name = Player_name + "y";
                            }
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_Z:
                            if(upppercase == 1){
                                Player_name = Player_name + "Z";
                            }
                            if(upppercase == 0){
                                Player_name = Player_name + "z";
                            }
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_SPACE:
                            Player_name = Player_name + " ";
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_BACK_SPACE:
                            Player_name = Player_name2;
                            Name_length = 0;
                            break;
                        case KeyEvent.VK_ENTER:
                            current_state = game_state.play_game;
                            break;
                        case KeyEvent.VK_1:
                            Player_name = Player_name + "1";
                            Name_length = Name_length + 1;
                            break;
                        case KeyEvent.VK_0:
                            Player_name = Player_name + "0";
                            Name_length = Name_length + 1;
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
                        switch (show_menu){
                            case 0:
                            move = 1;
                            domove = 1;
                            break;
                            case 1:
                                if (i_up != 240) {
                                i_up = i_up - 40;
                                }
                                break;
                            case 4:
                                if (menu_up != 170 && menu_up!= 165) {
                                    menu_up = menu_up - 30;
                                    m_up2 = m_up2 - 30;
                                    m_item = m_item - 1;
                                }
                                break;

                        }
                        break;
                    case KeyEvent.VK_S:
                        switch(show_menu) {
                            case 0:
                            move = 2;
                            domove = 1;
                            break;
                                case 1:
                                if (i_up != 320){
                                    i_up = i_up + 40;
                                }
                                break;
                                case 4:
                                    if (menu_up != 440 && menu_up!= 165){
                                        menu_up = menu_up + 30;
                                        m_up2 = m_up2 + 30;
                                        m_item = m_item + 1;
                                    }
                                    break;
                            }
                        break;
                    case KeyEvent.VK_A:
                        switch (show_menu) {
                            case 0:
                            move = 3;
                            domove = 1;
                            break;
                            case 4:
                                i_over = 80;
                                menu_up = 165;
                                break;
                        }
                        break;
                    case KeyEvent.VK_D:
                        switch(show_menu) {
                            case 0:
                            move = 4;
                            domove = 1;
                            break;
                            case 4:
                                i_over = 228;
                                menu_up = m_up2;
                                break;
                        }
                        break;
                    case KeyEvent.VK_H:
                        if(head == 0 && head_change == 0) {
                            head = 1;
                            head_change = 1;
                        }
                        if(head == 1 && head_change == 0){
                            head = 0;
                            head_change = 1;
                        }
                        head_change = 0;
                        break;
                    case KeyEvent.VK_K:
                        head = 3;
                        break;
                    case KeyEvent.VK_CONTROL:
                        walk_on = 1;
                        break;
                    case KeyEvent.VK_ESCAPE:
                        current_state = game_state.menu;
                        break;
                    case KeyEvent.VK_I:
                        if (show_menu == 0) {
                            move = 0;
                            show_menu = 1;
                            domove = 0;
                            i_up = 240;
                            i_over = 260;
                            select = 0;
                            pause = 1;
                            menwait = 1;
                        }
                        if (show_menu == 1 && menwait == 0){
                            walk_on = 0;
                            domove = 1;
                            pause = 0;
                            show_menu = 0;
                        }
                        menwait = 0;
                        break;
                    case KeyEvent.VK_ENTER:
                        if(show_menu == 1) {
                            select = 5;
                        }
                        if(show_menu == 4) {
                            select = 5;
                        }
                        break;
                }
                break;
            case encounter:
                if(click == 1){
                    switch (w.getKeyCode()) {
                        case KeyEvent.VK_W:
                            switch (show_menu) {
                                case 0:
                                    b_up = 500;
                                    break;
                                case 1:
                                    if (i_up != 477) {
                                        i_up = i_up - 30;
                                    }
                            }

                            break;
                        case KeyEvent.VK_S:
                            switch (show_menu) {
                                case 0:
                                    b_up = 550;
                                    break;
                                case 1:
                                    if (i_up != 567) {
                                        i_up = i_up + 30;
                                    }
                            }
                            break;
                        case KeyEvent.VK_A:
                                b_over = 20;
                                break;
                                case 4:
                            break;
                        case KeyEvent.VK_D:
                                b_over = 230;
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
                            switch (show_menu) {
                                case 0:
                                    switch (b_but) {
                                        case 1:
                                            select = 5;
                                            break;
                                        case 2:
                                            select = 5;
                                            break;
                                        case 3:
                                            select = 5;
                                            break;
                                        case 4:
                                            select = 5;
                                            break;
                                    }
                                    break;
                                case 1:
                                    switch (i_up){
                                        case 477:
                                            select = 5;
                                            heal = 1;
                                            break;
                                        case 507:
                                            select = 5;
                                            heal = 2;
                                            break;
                                        case 537:
                                            select = 5;
                                            heal = 3;
                                            break;
                                        case 567:
                                            select = 5;
                                            heal = 0;
                                            i_back = 1;
                                            break;
                                    }
                                    break;
                                case 2:
                                    show_menu = 3;
                                    if (xp >= lvlxp){
                                            xp = xp - lvlxp;
                                            lvl = lvl + 1;
                                            atkl = atkl + 2;
                                            atkh = atkh +2;
                                            def = def + 1;
                                            fhp = fhp + 5;
                                            hp = fhp;
                                            lvlxp = (int)(lvlxp * 1.8);
                                    }else{
                                        show_menu = 0;
                                        current_state = game_state.play_game;
                                    }
                                    break;
                                case 3:
                                    show_menu = 0;
                                    current_state = game_state.play_game;
                            }
                            break;
                    }
                }

                break;
            case end:
                switch (w.getKeyCode()){
                    case KeyEvent.VK_ENTER:
                        hp = 50;
                        current_state = game_state.play_game;
                        current_room = room.shop;
                        wo = 380;
                        wi = 280;
                        hp = 50;
                        buy4 = 0;
                        buy7 = 0;
                        buy8 = 0;
                        buy10 = 0;
                        d_buy = 0;
                        a_buy = 0;
                        xp_mult = 1;
                        gold_mult = 1;
                        vanilla_bean_coolata = 0;
                        atkh = 8;
                        atkl = 3;
                        def = 0;
                        spawntime = 500;
                        fe_hp = 50;
                        r_heal = 5;
                        b_heal = 2;
                        g_heal = 1;
                        access = 0;
                        lvl = 1;
                        lvlxp = 20;
                        xp = 0;
                        gold = 0;
                        Player_name = Player_name2;
                        current_state = game_state.menu;
                }
        }
    }
    @Override
    public void keyReleased(KeyEvent w) {
        switch(current_state) {
            case menu:
                break;
            case enter_name:
                switch (w.getKeyCode()) {
                    case KeyEvent.VK_SHIFT:
                        upppercase = 0;
                        break;
                }
                break;
            case play_game:
                if (show_menu != 1) {
                    switch (w.getKeyCode()) {
                        case KeyEvent.VK_W:
                            if (move == 1) {
                                domove = 0;
                            }
                            break;
                        case KeyEvent.VK_S:
                            if (move == 2) {
                                domove = 0;
                            }
                            break;
                        case KeyEvent.VK_A:
                            if (move == 3) {
                                domove = 0;
                            }
                            break;
                        case KeyEvent.VK_D:
                            if (move == 4) {
                                domove = 0;
                            }
                            break;
                        case KeyEvent.VK_CONTROL:
                            walk_on = 0;
                    }
                }
                break;
        }
    }

    private void draw(){

//get canvas
        Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
        switch(current_state) {

            case menu:
                //clear screen
                g.setColor(Color.black);
                g.fillRect(0, 0, WIDTH, HEIGHT);

                //draw fps
                g.setColor(Color.GREEN);
                g.drawString(Long.toString(fps), 10, 40);

                g.setColor(Color.GRAY);
                g.fillRect(200, 500, 400, 100);

                g.setColor(Color.GRAY);
                g.fillRect(200, 397, 400, 100);
                g.setFont(font7);
                g.setColor(Color.black);
                g.drawString("Play Game", 250, 485);

                g.setColor(Color.black);
                g.drawString("Quit", 340, 590);

                g.setColor(Color.red);
                g.fillRect(200, (int) m_up, 20, 100);
                if (select > 0) {
                    g.setColor(Color.white);
                    g.fillRect(200, (int) m_up, 400, 100);
                    select = select - 1;
                }
                break;
            case enter_name:
                g.setColor(Color.black);
                g.fillRect(0, 0, WIDTH, HEIGHT);

                g.setFont(font3);
                g.setColor(Color.gray);
                g.drawString("Enter Name:", 100, 100);

                g.setColor(Color.white);
                g.fillRect(180, 85, 200, 20);

                g.setFont(font3);
                g.setColor(Color.black);

                g.drawString(Player_name, 185, 102);
                break;
            case play_game:
                //clear screen
                g.setColor(Color.black);
                g.fillRect(0, 0, WIDTH, HEIGHT);
                //draw fps
                g.setColor(Color.GREEN);
                g.drawString(Long.toString(fps), 10, 40);

                g.setColor(Color.GRAY);
                g.fillRect((int) wo, (int) wi, 40, 40);
                if(head == 0) {
                    g.drawImage(g_hair, (int) wo - 50, (int) wi - 40, hair.getHeight() / 7, hair.getWidth() / 7, null);
                }
                if(head == 1){
                    g.drawImage(hair, (int) wo - 50, (int) wi - 40, hair.getHeight() / 7, hair.getWidth() / 7, null);
                }
                g.setColor(Color.yellow);
                g.setFont(font5);
                g.drawString(Integer.toString(gold) + "g", 95, 580);
                g.setColor(Color.cyan);
                g.drawString(Integer.toString(xp) + "xp", 170, 580);
                g.setColor(Color.white);
                g.drawString("lvl." + Integer.toString(lvl), 20, 580);
                g.setColor(Color.cyan);
                    g.setFont(font3);
                    g.drawString("xp needed: " + Integer.toString(lvlxp - xp), 170, 590);
                g.setFont(font5);
                g.setColor(Color.red);
                g.drawString("hp " + Integer.toString(hp) + "/" + Integer.toString(fhp), 700, 580);

                switch(current_room) {
                    case shop:
                        g.setColor(Color.yellow);
                        g.fillRect(345, 100, 100, 60);
                        g.setColor(Color.MAGENTA);
                        g.setFont(font6);
                        g.drawString("SHOP", 355, 150);
                        g.setColor(Color.GRAY);
                        g.fillRect(60, 50, 680, 10);
                        g.fillRect(60, 50, 10, 480);
                        g.fillRect(730, 50, 10, 480);
                        g.fillRect(60, 520, 290, 10);
                        g.fillRect(450, 520, 290, 10);
                        g.setColor(Color.white);
                        g.fillRect(350, 525, 100, 5);
                        break;
                    case dungeon1:
                        g.setColor(Color.GRAY);
                        g.fillRect(60, 50, 290, 10);
                        g.fillRect(450, 50, 290, 10);
                        g.fillRect(60, 50, 10, 480);
                        g.fillRect(730, 50, 10, 480);
                        g.fillRect(60, 520, 680, 10);
                        g.setColor(Color.white);
                        g.fillRect(350, 50, 100, 5);
                        g.setColor(Color.red);
                        g.fillRect(e_over1, e_up1, 30, 30);
                        g.setColor(Color.orange);
                        g.fillRect(e_over2, e_up2, 30, 30);
                        g.setColor(Color.yellow);
                        g.fillRect(e_over3, e_up3, 30, 30);
                        break;

                }
                g.setColor(Color.white);
                g.setFont(font4);
                if(debug == 1) {
                    g.drawString("wo: " + Integer.toString(wo), 325, 50);
                    g.drawString("wi: " + Integer.toString(wi), 425, 50);
                    g.drawString(Integer.toString(despawn1), 300, 580);
                    g.drawString(Integer.toString(despawn2), 400, 580);
                    g.drawString(Integer.toString(despawn3), 500, 580);
                    g.drawString("menu_up: " + Integer.toString(menu_up), 500, 50);
                    g.drawString("showmenu: " + Integer.toString(show_menu), 600, 50);
                    g.drawString("blink: " + Integer.toString(blink), 20, 50);
                    g.drawString("msl: " + Integer.toString(msl), 100, 50);
                    g.drawString("nogold: " + Integer.toString(nogold), 170, 50);
                }
                switch (show_menu) {
                    case 1:
                    g.setColor(Color.white);
                    g.fillRect(245, 220, 310, 160);
                    g.setColor(Color.black);
                    g.fillRect(250, 225, 300, 150);
                    g.setColor(Color.red);
                    g.fillRect((int) i_over, (int) i_up, 10, 20);
                    g.setColor(Color.white);
                    g.setFont(font6);
                    g.drawString("Red Potion x" + Integer.toString(r_heal), 290, 275);
                    g.drawString("Blue Potion x" + Integer.toString(b_heal), 290, 315);
                    g.drawString("Green Potion x" + Integer.toString(g_heal), 290, 355);
                    g.setColor(Color.red);
                    g.fillRect((int) i_over, (int) i_up, 20, 30);
                    if (select > 0) {
                        g.setColor(Color.white);
                        g.fillRect((int) i_over, (int) i_up, 250, 30);
                        select = select - 1;
                        if (select == 1) {
                            blink = 1;
                        }
                    }
                    break;
                    case 4:
                        g.setColor(Color.white);
                        g.fillRect(215, 140, 370, 340);
                        g.fillRect(145, 485, 510, 70);
                        g.setColor(Color.black);
                        g.fillRect(220, 145, 360, 330);
                        g.fillRect(150, 490, 500, 60);
                        g.setColor(Color.white);
                        g.setFont(font9);
                        g.drawString("Red Potion", 250, 200);
                        g.drawString("Blue Potion", 250, 230);
                        g.drawString("Green Potion", 250, 260);
                        if (buy4 == 1){
                            g.setColor(Color.gray);
                        }
                        g.drawString("xp multiplier", 250, 290);
                        g.setColor(Color.white);
                        g.drawString("armor", 250, 320);
                        g.drawString("weapon", 250, 350);
                        if (buy7 == 1){
                            g.setColor(Color.gray);
                        }
                        g.drawString("vanilla bean coolata", 250, 380);
                        g.setColor(Color.white);
                        if (buy8 == 1){
                            g.setColor(Color.gray);
                        }
                        g.drawString("decrease spawn time", 250, 410);
                        g.setColor(Color.white);
                        g.drawString("instant heal", 250, 440);
                        if (buy10 == 1){
                            g.setColor(Color.gray);
                        }
                        g.drawString("gold multiplier", 250, 470);
                        g.setColor(Color.white);
                        g.setColor(Color.red);
                        g.fillRect((int) i_over, (int) menu_up, 15, 25);
                        if (select > 0) {
                            switch (m_item){
                                case 1 :
                                     msl = 160;
                                     break;
                                case 2 :
                                    msl = 162;
                                    break;
                                case 3 :
                                    msl = 175;
                                    break;
                                case 4 :
                                    msl = 165;
                                    break;
                                case 5 :
                                    msl = 90;
                                    break;
                                case 6 :
                                    msl = 120;
                                    break;
                                case 7 :
                                    msl = 265;
                                    break;
                                case 8 :
                                    msl = 270;
                                    break;
                                case 9 :
                                    msl = 160;
                                    break;
                                case 10 :
                                    msl = 190;
                                    break;
                            }
                            if(m_back == 1){
                                msl = 100;
                            }
                            g.setColor(Color.white);
                            switch(m_item){
                                case 4:
                                    if(buy4 == 1 && menu_up != 165){
                                        g.setColor(Color.red);
                                    }
                                    break;
                                case 7:
                                    if(buy7 == 1 && menu_up != 165 || lvl < 15 && menu_up != 165){
                                        g.setColor(Color.red);
                                    }
                                    break;
                                case 8:
                                    if(buy8 == 1 && menu_up != 165){
                                        g.setColor(Color.red);
                                    }
                                    break;
                                case 10:
                                    if(buy10 == 1 && menu_up != 165){
                                        g.setColor(Color.red);
                                    }
                                    break;
                            }
                            if(nogold == 1 ){
                                if(m_back != 1) {
                                    g.setColor(Color.red);
                                }
                            }
                            g.fillRect((int) i_over, (int) menu_up, msl, 30);
                            select = select - 1;
                            if (select == 1) {
                                nogold = 0;
                                select = 0;
                                blink = 1;
                            }
                        }
                        g.setColor(Color.yellow);
                        g.drawString("30g", 500, 200);
                        g.drawString("80g", 500, 230);
                        g.drawString("150g", 500, 260);
                        g.drawString("1500", 500, 290);
                        g.drawString(Integer.toString(dprice) + "g", 500, 320);
                        g.drawString(Integer.toString(aprice) + "g", 500, 350);
                        g.drawString("5000g", 500, 380);
                        g.drawString("1000g", 500, 410);
                        g.drawString("200g", 500, 440);
                        g.drawString("2000g", 500, 470);
                        g.setFont(font5);
                        g.setColor(Color.white);
                        switch (m_item){
                            case 1:
                                g.drawString("*a bottle with red potion in it that heals 30 hp*", 170, 530);
                                break;
                            case 2:
                                g.drawString("*a bottle with blue potion in it that heals 50 hp*", 170, 530);
                                break;
                            case 3:
                                g.drawString("*a bottle with green potion in it that heals 80 hp*", 170, 530);
                                break;
                            case 4:
                                g.drawString("*gain twice as much xp*", 170, 530);
                                break;
                            case 5:
                                g.drawString("*buy more armor to increase your defence*", 170, 530);
                                break;
                            case 6:
                                g.drawString("*improve your weapon to increase your attack*", 170, 530);
                                break;
                            case 7:
                                g.drawString("*why would anyone buy this?*", 170, 530);
                                break;
                            case 8:
                                g.drawString("*make enemies spawn faster*", 170, 530);
                                break;
                            case 9:
                                g.drawString("*heal all your hp*", 170, 530);
                                break;
                            case 10:
                                g.drawString("*you get more gold and surprisingly, it's not a scam*", 170, 530);
                                break;
                        }
                        g.drawString("Back", 100, 190);
                        break;
                }
                break;
            case encounter:
                g.setColor(Color.black);
                g.fillRect(0, 0, WIDTH, HEIGHT);

                //draw fps
                g.setColor(Color.GREEN);
                g.drawString(Long.toString(fps), 10, 40);
                switch (show_menu){
                    case 0:
                        g.setColor(Color.gray);
                        g.fillRect(20, 500, 200, 40);

                        g.setColor(Color.gray);
                        g.fillRect(20, 550, 200, 40);

                        g.setColor(Color.gray);
                        g.fillRect(230, 500, 200, 40);

                        g.setColor(Color.gray);
                        g.fillRect(230, 550, 200, 40);
                        g.setFont(font6);
                        g.setColor(Color.white);
                        g.drawString("FIGHT", 85, 540);
                        g.drawString("ITEM", 90, 590);
                        g.drawString("SKILLS", 280, 540);
                        g.drawString("RUN", 300, 590);
                        g.setColor(Color.red);
                        g.fillRect((int) b_over, (int) b_up, 20, 40);
                        if (select > 0) {
                            g.setColor(Color.white);
                            g.fillRect((int) b_over, (int) b_up, 200, 40);
                            select = select - 1;
                        }
                        break;
                    case 1:
                        g.setColor(Color.red);
                        if(i_up == 0){
                            i_up = 477;
                        }
                        g.fillRect((int) i_over, (int) i_up, 10, 20);
                        g.setColor(Color.white);
                        setFont(font8);
                        g.drawString("Red Potion x" + Integer.toString(r_heal), 30, 500);
                        g.drawString("Blue Potion x" + Integer.toString(b_heal), 29, 530);
                        g.drawString("Green Potion x" + Integer.toString(g_heal), 29, 560);
                        g.drawString("Back", 30, 590);
                        if (select > 0) {
                            g.setColor(Color.white);
                            g.fillRect((int) i_over, (int) i_up, 180, 20);
                            select = select - 1;
                            if (select == 1){
                                blink = 1;
                            }
                        }
                        break;
                    case 2:
                        g.setFont(font5);
                        g.setColor(Color.white);
                        g.drawString("you got " + Integer.toString(addgold) + " gold and " + Integer.toString(addxp) + " xp!", 30, 570);
                        break;
                    case 3:
                        g.setFont(font5);
                        g.setColor(Color.white);
                        g.drawString("you leveled up! attack + 2, defense + 1, hp +5!", 30, 570);
                        break;
                }
                g.setColor(Color.white);
                g.setFont(font6);
                g.fillRect(455,498,315, 34);

                g.setFont(font3);
                g.setColor(Color.black);
                g.drawString(Player_name, 460, 522);

                g.setColor(Color.gray);
                g.fillRect(557,501,206, 28);

                if((hp * 10 / fhp * 10) >= 71) {
                    g.setColor(Color.green);
                }
                if((hp * 10 / fhp * 10) <= 70 && (hp * 10 / fhp * 10) >= 31){
                    g.setColor(Color.yellow);
                }
                if((hp * 10 / fhp * 10) <= 30){
                    g.setColor(Color.red);
                }
                g.fillRect(560,504,(int)hp * (200 / fhp), 22);
                g.setColor(Color.black);
                g.drawString(Integer.toString(hp) + "/" + Integer.toString(fhp), 650, 523);
                switch (encounter){
                    case 1:
                        g.setColor(Color.white);
                        g.setFont(font6);
                        g.fillRect(25,48,315, 34);

                        g.setFont(font3);
                        g.setColor(Color.black);
                        g.drawString("Anthrax", 30, 72);
                        g.drawImage(anthrax, 370, (int) 80, anthrax.getWidth() / 4, anthrax.getHeight() / 4, null);
                        g.setColor(Color.gray);
                        g.fillRect(127,51,206, 28);

                        if((e_hp * 10/ fe_hp * 10) >= 71) {
                            g.setColor(Color.green);
                        }
                        if((e_hp * 10/ fe_hp * 10) <= 70 && (e_hp * 10/ fe_hp * 10) >= 31){
                            g.setColor(Color.yellow);
                        }
                        if((e_hp * 10/ fe_hp * 10) <= 30){
                            g.setColor(Color.red);
                        }

                        g.fillRect(130,54,(int)e_hp * (200 / fe_hp), 22);

                        g.setColor(Color.black);
                        g.drawString(Integer.toString(e_hp) + "/" + Integer.toString(fe_hp), 220, 73);
                        break;
                    case 2:
                        g.setColor(Color.white);
                        g.setFont(font6);
                        g.fillRect(25,48,315, 34);

                        g.setFont(font3);
                        g.setColor(Color.black);
                        g.drawString("Humungousaur", 30, 72);
                        g.drawImage(dontsuemesaur, 520, (int) 80, dontsuemesaur.getWidth() / 4, dontsuemesaur.getHeight() / 4, null);
                        g.setColor(Color.gray);
                        g.fillRect(127,51,206, 28);

                        if((e_hp * 10/ fe_hp * 10) >= 71) {
                            g.setColor(Color.green);
                        }
                        if((e_hp * 10/ fe_hp * 10) <= 70 && (e_hp * 10/ fe_hp * 10) >= 31){
                            g.setColor(Color.yellow);
                        }
                        if((e_hp * 10/ fe_hp * 10) <= 30){
                            g.setColor(Color.red);
                        }

                        g.fillRect(130,54,(int)e_hp * (200 / fe_hp), 22);

                        g.setColor(Color.black);
                        g.drawString(Integer.toString(e_hp) + "/" + Integer.toString(fe_hp), 220, 73);
                        break;
                    case 3:
                        g.setColor(Color.white);
                        g.setFont(font6);
                        g.fillRect(25,48,315, 34);

                        g.setFont(font3);
                        g.setColor(Color.black);
                        g.drawString("slime", 30, 72);

                        g.drawImage(slime, 450, (int) 130, hair.getHeight() / 7, hair.getWidth() / 7, null);

                        g.setColor(Color.gray);
                        g.fillRect(127,51,206, 28);

                        if((e_hp * 10/ fe_hp * 10) >= 71) {
                            g.setColor(Color.green);
                        }
                        if((e_hp * 10/ fe_hp * 10) <= 70 && (e_hp * 10/ fe_hp * 10) >= 31){
                            g.setColor(Color.yellow);
                        }
                        if((e_hp * 10/ fe_hp * 10) <= 30){
                            g.setColor(Color.red);
                        }
                        g.fillRect(130,54,(int)e_hp * (200 / fe_hp), 22);
                        g.setColor(Color.black);
                        g.drawString(Integer.toString(e_hp) + "/" + Integer.toString(fe_hp), 220, 73);
                        break;
                }
                g.setColor(Color.gray);
                g.fillRect(80,300, 140, 140);
                switch(head){
                    case 0:
                        g.drawImage(g_hair, 393, (int) 150, hair.getWidth() / -2, hair.getHeight() / 2, null);
                        break;
                    case 1:
                    g.drawImage(hair, 393, (int) 150, hair.getWidth() / -2, hair.getHeight() / 2, null);
                    break;
                }
                if (debug == 1){
                    g.setFont(font4);
                    g.setColor(Color.white);
                    g.drawString("e_def:" + Integer.toString(e_def), 500, 100);
                    g.drawString("attack:" + Integer.toString(attack), 500, 130);
                    g.drawString("def:" + Integer.toString(def), 500, 160);
                    g.drawString("e_attack:" + Integer.toString(e_attack), 500, 190);
                }
                break;
            case end:
                g.setColor(Color.red);
                g.fillRect(0,0,WIDTH, HEIGHT);

                g.setFont(font7);
                g.setColor(Color.black);
                g.drawString("DEATH", 290, 330);

        }

        //release resources, show the buffer
        g.dispose();
        strategy.show();
    }
    public void paint(Graphics g){
        g.drawImage(hair, (int) wo, (int) wi, null);
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