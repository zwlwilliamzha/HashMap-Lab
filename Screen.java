import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Font;
import java.awt.Color;
import java.awt.Image;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.net.URL;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Screen extends JPanel implements ActionListener {

    private MyHashMap<State,StateInfo> map;

    private JTextArea states;
    private JScrollPane scroll;

    private JTextArea info;
    private JScrollPane scrollInfo;

    private JTextField search;
    private JTextField url1;
    private JTextField url2;
    private JTextField url3;
    
    private JTextField name;
    private JTextField abbr;
    private JTextField capital;
    private JTextField population;
    private JTextField size;

    private JButton enter;
    private JButton delete;
    private JButton addPic;
    private JButton addState;

    private JButton addImg;
    private JButton addNew;
    private JButton back;

    private State current;
    private int screen;

    private Font fontSecondary;
    private Font fontTertiary;

    private Color lightBlue;

    public Screen() {

        //variables
        current = null;
        screen = 1;

        //colors
        lightBlue = new Color(230,246,252);

        //fonts
        fontSecondary = new Font("Georgia",Font.PLAIN,20);
        fontTertiary = new Font("Georgia",Font.PLAIN,15);

        map = new MyHashMap<State,StateInfo>();

        //California
        DLList<String> l1 = new DLList<String>();
        l1.add("https://www.planetware.com/photos-large/USCA/california-golden-gate-bridge-night.jpg");
        l1.add("https://www.discoverlosangeles.com/sites/default/files/business/disneyland-park/h_2000-crm-la-disneyland0-6a3322105056a36_6a3323af-5056-a36f-23e7498faf405903.jpg");

        State ca = new State("California","ca");
        StateInfo caInfo = new StateInfo("Sacramento",39240000,163696,l1);

        map.put(ca,caInfo);

        //Massachusetts
        DLList<String> l2 = new DLList<String>();
        l2.add("https://www.onlyinyourstate.com/wp-content/uploads/2017/02/1018px-Leonard_P._Zakim_Bunker_Hill_Bridge_-_Boston_MA_crop-e1487164112128.jpg");
        l2.add("https://cdn.tripster.com/travelguide/wp-content/uploads/2020/08/boston-massachusetts-usa-george-washington-boston-common.jpg");

        State ma = new State("Massachusetts","ma");
        StateInfo maInfo = new StateInfo("Boston",6985000,10565,l2);

        map.put(ma,maInfo);

        //Hawaii
        DLList<String> l3 = new DLList<String>();
        l3.add("https://media.tacdn.com/media/attractions-splice-spp-674x446/0c/05/26/2a.jpg");
        l3.add("https://loveoahu.org/wp-content/uploads/snorkeling-hanauma-bay-1.jpg");

        State hi = new State("Hawaii","hi");
        StateInfo hiInfo = new StateInfo("Honolulu",1442000,10931,l3);

        map.put(hi,hiInfo);

        //buttons
        enter = new JButton("View Info");
        enter.setBounds(425,70,90,30);
        this.add(enter);
        enter.addActionListener(this);
        enter.setVisible(true);

        delete = new JButton("Delete");
        delete.setBounds(505,70,90,30);
        this.add(delete);
        delete.addActionListener(this);
        delete.setVisible(true);

        addPic = new JButton("Add Pictures");
        addPic.setBounds(585,70,130,30);
        this.add(addPic);
        addPic.addActionListener(this);
        addPic.setVisible(true);

        addState = new JButton("Add New State");
        addState.setBounds(85,520,265,30);
        this.add(addState);
        addState.addActionListener(this);
        addState.setVisible(true);

        addImg = new JButton("Add Image(s)");
        addImg.setBounds(90,350,150,30);
        this.add(addImg);
        addImg.addActionListener(this);
        addImg.setVisible(true);

        addNew = new JButton("Add State");
        addNew.setBounds(85,500,150,30);
        this.add(addNew);
        addNew.addActionListener(this);
        addNew.setVisible(true);

        back = new JButton("Back");
        back.setBounds(625,70,90,30);
        this.add(back);
        back.addActionListener(this);
        back.setVisible(true);

        //text area
        states = new JTextArea(); //sets the location and size
        states.setText(map.keySet().toDLList().toString());
        states.setBounds(90,110,250,310);
        states.setEditable(false);
        this.add(states);

        scroll = new JScrollPane(states); 
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(90,110,250,410);
        this.add(scroll);

        info = new JTextArea(); //sets the location and size
        info.setText("");
        info.setBounds(350,110,360,100);
        info.setEditable(false);
        this.add(info);

        scrollInfo = new JScrollPane(info); 
        scrollInfo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollInfo.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollInfo.setBounds(350,110,360,100);
        this.add(scrollInfo);

        //text fields
        search = new JTextField("Enter Abbreviation");
        search.setBounds(85,70,340,30);
        this.add(search);
        search.setVisible(true);

        url1 = new JTextField("");
        url1.setBounds(175,150,340,30);
        this.add(url1);
        url1.setVisible(true);

        url2 = new JTextField("");
        url2.setBounds(175,180,340,30);
        this.add(url2);
        url2.setVisible(true);

        url3 = new JTextField("");
        url3.setBounds(175,210,340,30);
        this.add(url3);
        url3.setVisible(true);

        //new state textfields

        name = new JTextField("");
        name.setBounds(215,150,385,30);
        this.add(name);
        name.setVisible(true);

        abbr = new JTextField("");
        abbr.setBounds(260,180,340,30);
        this.add(abbr);
        abbr.setVisible(true);

        capital = new JTextField("");
        capital.setBounds(225,210,375,30);
        this.add(capital);
        capital.setVisible(true);

        population = new JTextField("");
        population.setBounds(245,240,355,30);
        this.add(population);
        population.setVisible(true);

        size = new JTextField("");
        size.setBounds(200,270,400,30);
        this.add(size);
        size.setVisible(true);

        setLayout(null);
        setFocusable(true);
    }

    public Dimension getPreferredSize() {
        return new Dimension(800,600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //draw here

        g.setColor(lightBlue);
        g.fillRect(0,0,800,600);

        g.setColor(Color.WHITE);
        g.fillRect(50,50,700,500);

        if (screen == 1) { //view all states

            if (current != null) {
                int y = 220;
                int x = 350;
                for (int i = 0; i < map.get(current).images().size(); i++) {
                    
                    try {
                    // System.out.println(map.get(current).images().get(i));
                    URL url = new URL(map.get(current).images().get(i));
                    Image img = ImageIO.read(url);
                    
                    if (i % 2 == 0 &&  i != 0) {
                        x+=150;
                        y=220;
                    }

                    g.drawImage(img,x,y,145,145,null);
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                    y+=150;
                }
            }

            delete.setVisible(true);
            search.setVisible(true);
            states.setVisible(true);
            info.setVisible(true);
            enter.setVisible(true);
            addPic.setVisible(true);
            addState.setVisible(true);
            scroll.setVisible(true);
            scrollInfo.setVisible(true);

            addImg.setVisible(false);
            addNew.setVisible(false);
            back.setVisible(false);
            url1.setVisible(false);
            url2.setVisible(false);
            url3.setVisible(false);
            name.setVisible(false);
            abbr.setVisible(false);
            capital.setVisible(false);
            population.setVisible(false);
            size.setVisible(false);
    
        } else if (screen == 2) { //add state images

            g.setFont(fontSecondary);
            g.setColor(Color.BLACK);
            g.drawString("Add up to 3 Landmark Images:",90,90);

            g.setFont(fontTertiary);
            g.drawString("Enter URL:",90,170);
            g.drawString("Enter URL:",90,200);
            g.drawString("Enter URL:",90,230);

            addImg.setVisible(true);
            back.setVisible(true);

            url1.setVisible(true);
            url1.setBounds(175,150,340,30);

            url2.setVisible(true);
            url2.setBounds(175,180,340,30);

            url3.setVisible(true);
            url3.setBounds(175,210,340,30);

            enter.setVisible(false);
            delete.setVisible(false);
            search.setVisible(false);
            states.setVisible(false);
            info.setVisible(false);
            addPic.setVisible(false);
            addState.setVisible(false);
            scroll.setVisible(false);
            scrollInfo.setVisible(false);
            addNew.setVisible(false);
            name.setVisible(false);
            abbr.setVisible(false);
            capital.setVisible(false);
            population.setVisible(false);
            size.setVisible(false);

        } else if (screen == 3) { //add new state

            g.setFont(fontSecondary);
            g.setColor(Color.BLACK);
            g.drawString("Add New State:",90,90);

            g.setFont(fontTertiary);
            g.drawString("Enter State Name:",90,170);
            g.drawString("Enter State Abbreviation:",90,200);
            g.drawString("Enter State Capital:",90,230);
            g.drawString("Enter State Population:",90,260);
            g.drawString("Enter State Size:",90,290);

            g.setFont(fontSecondary);
            g.drawString("Add up to 3 Images:",90,350);

            g.setFont(fontTertiary);
            g.drawString("Enter URL:",90,410);
            g.drawString("Enter URL:",90,440);
            g.drawString("Enter URL:",90,470);

            
            back.setVisible(true);
            addNew.setVisible(true);
            name.setVisible(true);
            abbr.setVisible(true);
            capital.setVisible(true);
            population.setVisible(true);
            size.setVisible(true);

            url1.setVisible(true);
            url1.setBounds(175,390,340,30);

            url2.setVisible(true);
            url2.setBounds(175,420,340,30);

            url3.setVisible(true);
            url3.setBounds(175,450,340,30);

            enter.setVisible(false);
            delete.setVisible(false);
            search.setVisible(false);
            states.setVisible(false);
            info.setVisible(false);
            addPic.setVisible(false);
            addImg.setVisible(false);
            scroll.setVisible(false);
            scrollInfo.setVisible(false);
            addState.setVisible(false);

        }


        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enter) {
            State newCurrent = new State("",search.getText());
            if (map.contains(newCurrent) && !search.getText().equals("")) {
                current = newCurrent;
                info.setText(map.get(current).toString());
            }
        } else if (e.getSource() == delete) {
            State newCurrent = new State("",search.getText());
            if (map.contains(newCurrent) && !search.getText().equals("")) {
                current = newCurrent;
                map.remove(current);
                info.setText("");
                search.setText("");
                current = null;
                states.setText(map.keySet().toString());
            }
        } else if (e.getSource() == addPic) {
            State newCurrent = new State("",search.getText());
            if (map.contains(newCurrent) && !search.getText().equals("")) {
                current = newCurrent;
                screen = 2;
            }
        } else if (e.getSource() == back) {
            screen = 1;
        } else if (e.getSource() == addState) {
            screen = 3;
        } else if (e.getSource() == addImg) {
            if (!url1.getText().equals("")) {
                map.get(current).addImage(url1.getText());
                url1.setText("");
            }
            if (!url2.getText().equals("")) {
                map.get(current).addImage(url2.getText());
                url2.setText("");
            }
            if (!url3.getText().equals("")) {
                map.get(current).addImage(url3.getText());
                url3.setText("");
            }

            search.setText(current.abbreviation());
            info.setText(map.get(current).toString());
            screen = 1;
        } else if (e.getSource() == addNew) {
            String n = name.getText();
            name.setText("");

            String a = abbr.getText();
            abbr.setText("");

            String c = capital.getText();
            capital.setText("");

            int p = Integer.parseInt(population.getText());
            population.setText("");

            int s = Integer.parseInt(size.getText());
            size.setText("");

            DLList<String> links = new DLList<String>();

            if (!url1.getText().equals("")) {
                links.add(url1.getText());
                url1.setText("");
            }
            if (!url2.getText().equals("")) {
                links.add(url2.getText());
                url2.setText("");
            }
            if (!url3.getText().equals("")) {
                links.add(url3.getText());
                url3.setText("");
            }

            map.put((new State(n,a)),new StateInfo(c,p,s,links));
            states.setText(map.keySet().toString());
            current = new State("",a);
            search.setText(a);
            info.setText(map.get(current).toString());

            screen = 1;
        }

        repaint();
    }
}

