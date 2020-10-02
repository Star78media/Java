package MusicMain;


import static javax.swing.JFileChooser.APPROVE_OPTION;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.filechooser.FileNameExtensionFilter;





public class Player extends time  implements ActionListener {

	JFrame jf;
    JButton ppButton, forwardButton, backwardButton, folderButton, settingButton;
    JFileChooser choose;
    JSlider slider;
    JLabel timeStart,timeStop,frontText,headText;

  
    Clip clip;
    AudioInputStream audio;
    Icon play = new ImageIcon("Images\\playbutton.png");
    Icon pause = new ImageIcon("Images\\pausebutton.png");
    Icon forward = new ImageIcon("Images\\forwardbutton.png");
    Icon backward = new ImageIcon("Images\\backwardbutton.png");
    Icon folders = new ImageIcon("Images\\folderbutton.png");
    Icon set = new ImageIcon("Images\\settingbutton.png");
    Icon citat = new ImageIcon("Images\\WeLoveMusic.png");
    Icon head = new ImageIcon("images\\musicheade.png");
    boolean status =false;
    

    public static void main(String[] args) {
     new Player();}
        

    public Player() {
        jf = new JFrame(" My Little Audio Player");
        jf.setSize(550, 400);
        jf.getContentPane().setBackground(Color.white);
        jf.setLayout(null);
       
         addElements();
		 jf.add(ppButton);
	     jf.add(forwardButton);
	     jf.add(backwardButton);
	     jf.add(slider);
	     jf.add(folderButton);
	     jf.add(timeStart);
	     jf.add(timeStop);
	     jf.add(frontText);
	     jf.add(headText);
	     jf.add(settingButton); 
	    
	     jf.setIconImage(new ImageIcon("Images\\Logomusic.png").getImage());
	     jf.setDefaultCloseOperation(3);
	     jf.setLocationRelativeTo(null);
	     jf.setResizable(false);
	     jf.setVisible(true);
    }
public void addElements() {   
		
        ppButton = new JButton(play);
        ppButton.setBounds(200, 120, 125, 125);
        ppButton.setBackground(Color.white);
        ppButton.setBorder(null);
        ppButton.addActionListener((ActionListener) this);

        forwardButton = new JButton(forward);
        forwardButton.setBounds(365, 120, 125, 125);
        forwardButton.setBackground(Color.white);
        forwardButton.setBorder(null);
        forwardButton.addActionListener((ActionListener) this);

        backwardButton = new JButton(backward);
        backwardButton.setBounds(45, 120, 125, 125);
        backwardButton.setBackground(Color.white);
        backwardButton.setBorder(null);
        backwardButton.addActionListener((ActionListener) this);

        slider = new JSlider();
        slider.setBounds(10, 80, 520, 25);
        slider.setBackground(Color.white);
        slider.setPaintTrack(true);
        slider.setBorder(null);
        slider.setMinimum(0);
        slider.setValue(0);

        folderButton = new JButton(folders);
        folderButton.setBounds(30, 20, 30, 30);
        folderButton.setBackground(Color.white);
        folderButton.setBorder(null);
        folderButton.addActionListener((ActionListener) this);

        timeStart=new JLabel("00 : 00",JLabel.CENTER);
        timeStart.setBounds(10,105,50,20);
        timeStart.setOpaque(true);
        timeStart.setBackground(Color.white);
        timeStart.setForeground(Color.black);


        timeStop=new JLabel("00 : 00",JLabel.CENTER);
        timeStop.setBounds(470,105,50,20);
        timeStop.setOpaque(true);
        timeStop.setBackground(Color.white);
        timeStop.setForeground(Color.black);

        
		frontText = new JLabel(citat);
		frontText.setBounds(150,200, 250, 125);
		frontText.setBackground(Color.white);
		frontText.setBorder(null);
       
      
		headText = new JLabel(head);
		headText.setBounds(400,2, 125, 83);
		headText.setBackground(Color.white);
		headText.setBorder(null);
    
        settingButton = new JButton(set);
        settingButton.setBounds(100, 20, 30, 30);
        settingButton.setBackground(Color.white);
        settingButton.setBorder(null);
        settingButton.addActionListener((ActionListener) this);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(folderButton)) {
            choose = new JFileChooser("");
            choose.setAcceptAllFileFilterUsed(false);
            choose.addChoosableFileFilter(new FileNameExtensionFilter("wav","Wav"));
            choose.setBackground(Color.WHITE);
            choose.setForeground(Color.WHITE);
            int i = choose.showOpenDialog(jf);

            if (i == APPROVE_OPTION)
            {
                File file = choose.getSelectedFile();
                if (file.getName().endsWith(".wav")) {
                    try 
                    {
                        audio = AudioSystem.getAudioInputStream(file);
                        clip = AudioSystem.getClip();
                        clip.open(audio);
                        clip.start();
                        



                        status=true;
                        ppButton.setIcon(pause);
                        timeStop.setText(super.calculate_time(clip.getMicrosecondLength()));
                        
                        slider.setMaximum((int)super.MicroSeconds_2_seconds(clip.getMicrosecondLength())+1);
                        super.StartTimer(slider,timeStart,(int)super.MicroSeconds_2_seconds(clip.getMicrosecondLength())+1);

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(jf, ex.getMessage(), "Error", 0);
                    }
                 }
                 else
                 {
                    JOptionPane.showMessageDialog(jf, "Please select '.wav' files.", "Alert", 1);
                 }

            }   
        }
        else if(e.getSource().equals(ppButton))
        {
            if(clip==null)
            {
                //
            }
            else
            {
                if(status)
                {
                    status =false;
                    clip.stop();
                    super.stopTimer();
                    ppButton.setIcon(play);
                }
                else
                {
                    status = true;
                    clip.start();
                    super.StartTimer(slider, timeStart,(int)super.MicroSeconds_2_seconds(clip.getMicrosecondLength())+1);
                    ppButton.setIcon(pause);
                }
            }
        }
        else if(e.getSource().equals(forwardButton))
        {
            if(clip==null)
            {

            }
            else if(clip.isRunning())
            {
                if(clip.getMicrosecondPosition()<clip.getMicrosecondLength()-10000000)
                {
                    long position = clip.getMicrosecondPosition();
                    clip.stop();
                    super.stopTimer();
                    clip.setMicrosecondPosition(position+10000000);
                    seconds+=10;
                    super.StartTimer(slider, timeStart,(int)super.MicroSeconds_2_seconds(clip.getMicrosecondLength())+1);
                    clip.start();
                }
            }
            else
            {
                long position = clip.getMicrosecondPosition();
                clip.setMicrosecondPosition(position+10000000);
                seconds+=10;

            }
        }
        else if(e.getSource().equals(backwardButton))
        {
            if(clip==null)
            {

            }
            else if(clip.isRunning())
            {
                if(clip.getMicrosecondPosition()>10000000)
                {
                    long position = clip.getMicrosecondPosition();
                    clip.stop();
                    super.stopTimer();
                    clip.setMicrosecondPosition(position-10000000);
                    
                    seconds-=10;
                    super.StartTimer(slider, timeStart,(int)super.MicroSeconds_2_seconds(clip.getMicrosecondLength())+1);
                    clip.start();
                }
                else
                {
                    clip.stop();
                    super.stopTimer();
                    clip.setMicrosecondPosition(0l);
                    
                    seconds=0;
                    super.StartTimer(slider, timeStart,(int)super.MicroSeconds_2_seconds(clip.getMicrosecondLength())+1);
                    clip.start();
                }
            }
            else 
            {
                if(clip.getMicrosecondPosition()>10000000)
                {
                    clip.setMicrosecondPosition(clip.getMicrosecondLength()-10000000);
                    seconds-=10;
                }
                else
                {
                    clip.setMicrosecondPosition(0l);
                    seconds=0;
                }
            }
        }
    }
}