// @author : nicko

package editor;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.FileWriter;
import javax.swing.*;
import static javax.swing.JOptionPane.YES_OPTION;
 
public class Editor extends JFrame {

    public Editor() {
        initComponents();
    }
  
    private void initComponents() {
    
        p = new JPanel(new BorderLayout());
        
        tb = new JToolBar();
        
        openButton = new JButton("Open");
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doOpen();
            }
        });
        
        saveButton = new JButton("Save"); 
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doSave();
            }
        });
        
        exitButton = new JButton("exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doExit();
            }
        });
        
        tb.add(openButton);
        tb.add(saveButton);
        tb.add(exitButton);
        
        tarea = new JTextArea(20,60);
        sc = new JScrollPane(tarea);
        
        p.add(tb,BorderLayout.NORTH);
        p.add(sc);
        
        
        fc = new JFileChooser();
        mb = new JMenuBar();
        mnu = new JMenu("File");
        
        newMni = new JMenuItem("New");
        newMni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doNew();
            }
        });
        
        openMni = new JMenuItem("Open");
        openMni.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                doOpen();
            }
        });
        
        saveMni = new JMenuItem("Save");
        saveMni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                doSave();
            }
        });
        
        exitMni = new JMenuItem("Exit");
        exitMni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doExit();
            }
        });
        
        mnu.add(newMni);
        mnu.add(openMni);
        mnu.add(saveMni);
        mnu.add(exitMni);
        
        mnui = new JMenu("About");
        
        infoMni = new JMenuItem("Info");
        
        infoMni.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                doInfo();
            }
        });
        
        mnui.add(infoMni);
        mb.add(mnu);
        mb.add(mnui);
        
        
        setJMenuBar(mb);
        
        add(p);        
        pack();
    }
    
    private void doInfo(){
        String msg = "Editor, developed in Java\nauthor:Mouzakitis Nikolaos.";
        
        JOptionPane.showMessageDialog(this, msg,"Informations", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void doExit() {
        System.exit(0);
    }
    private void doSave(){
        fc.showSaveDialog(this);
        theFile = fc.getSelectedFile();
        
        if(theFile == null)
            return;
        
        FileWriter myFile = null;
        BufferedWriter buff = null;
        
        try {
            myFile = new FileWriter(theFile);
            buff = new BufferedWriter(myFile);
            buff.write(tarea.getText());
            
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                buff.flush();
                buff.close();
                myFile.close();
                
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        
    }
    
    private void doOpen() {
        String msg = "All unsaved changes will be lost.\nProceed?";
        int dialogResult;
        
        dialogResult =JOptionPane.showConfirmDialog(this, msg,"Unsaved changes", JOptionPane.YES_NO_OPTION);
        
        if(dialogResult == YES_OPTION) {
        
            fc.showOpenDialog(this);
            theFile = fc.getSelectedFile();

            if(theFile == null)
                return;
        
            FileReader myFile = null;
            BufferedReader buff = null;
            try {
                myFile  = new FileReader(theFile);
                buff = new BufferedReader(myFile);
            
                while(true) {
                  String line = buff.readLine();
                    if(line == null)
                        break;
                 tarea.append(line + '\n');
                }
            
            } catch(IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    buff.close();
                    myFile.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private void doNew() {
        String msg = "All unsaved changes will be lost.\nProceed?";
        int dialogResult;
        
        dialogResult =JOptionPane.showConfirmDialog(this, msg,"Unsaved changes", JOptionPane.YES_NO_OPTION);
        
        if(dialogResult == YES_OPTION) {
        
            tarea.setText(null);
            tarea.requestFocus();
        }
        
    }
    
    private JPanel p;
    private JToolBar tb;
    private JScrollPane sc;
    private JButton openButton, saveButton,exitButton;
    private JTextArea tarea;
    private JMenu mnu , mnui;
    private JMenuBar mb;
    private File theFile;
    private JFileChooser fc;
    private JMenuItem newMni, openMni, saveMni, exitMni,infoMni;
    
    public static void main(String[] args) {
        Editor ed = new Editor();
        ed.setTitle("Editor v1");
        ed.setVisible(true);
        ed.setSize(700,500);
        ed.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
