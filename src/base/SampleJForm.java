package base;
import nexus.NexusGen;
import com.itextpdf.text.pdf.parser.Matrix;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.Visibility;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import learners.ReLearner;
import learners.regexTemplate;
import learners.Pairs;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/

/**
*
* @author prasad
*/
public class SampleJForm extends javax.swing.JFrame {
    /**
* Creates new form SampleJForm
*/
    public SampleJForm() {
        initComponents();
    }

    /**
* This method is called from within the constructor to initialize the form.
* WARNING: Do NOT modify this code. The content of this method is always
* regenerated by the Form Editor.
*/
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        
        //jMenuBar1.setVisible(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MorphoBank");

        jButton6.setText("Load");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jButton6ActionPerformed(evt);
            
             jMenuItem1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Load the Project File which needs to be learnt");
        jScrollPane2.setViewportView(jTextArea1);

        jButton1.setText("Select");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Modes");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Characters", "States" }));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Characters", "States"
            }
        ));
        jScrollPane1.setViewportView(jTable2);

        jButton2.setText("Apply");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane4.setViewportView(jTextArea3);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jButton3.setText("Reset");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Gen Nexus");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        fileMenu.setText("File");
        fileMenu.setName("File_Menu");

        jMenuItem1.setText("Pdf to Text");
        jMenuItem1.setName("PdfToText");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem1);

        jMenuItem2.setText("Word to Text");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem2);

        jMenuBar1.add(fileMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(jLabel1))
                        .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addGap(57, 57, 57)
                        .addComponent(jButton4))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
        );

        pack();
    } /* End of init components */

    private String fileinput ;
    
    /*
* jButton6 - Load file
* Provides implementation for load file button
*/
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        FileDialog fileDlg = new FileDialog(this,"Select the file");
        fileDlg.show();
        String fileName = fileDlg.getDirectory() + "//" + fileDlg.getFile();
        
        System.out.print(fileName);
        LoadContents(fileName);
        fileinput = fileName;
    }//GEN-LAST:event_jButton6ActionPerformed

    private int rowCount = 0;
    private HashMap table = new HashMap();
    
    private Vector<characterStatePair> pairs = new Vector<characterStatePair>();
    class characterStatePair
    {
        String lineContent;
        int linenumber ;
        character c;
        Vector<states> s = new Stack<states>() ;
    }
    class character
    {
        String value;
        int startpos;
        int endpos;
     public character()
     {
     value ="";
     int startpos = -1;
     int endpos = -1;
     }
    }
    
    class states
    {
        String value;
        int startpos;
        int endpos;
    }
    
     
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try {
           int lineNumber = jTextArea1.getLineOfOffset(jTextArea1.getSelectionStart());
           
           System.out.print(lineNumber);
           
           if(table.containsKey(lineNumber))
           {
                int col = 0;
                if( jComboBox1.getSelectedItem().equals("States"))
                {
                    int size = pairs.size();
                    for(int i = 0 ; i < size ;i++)
                    {
                        if(pairs.get(i).linenumber == lineNumber)
                        {
                            states s_state = new states();
                            s_state.value = jTextArea1.getSelectedText();
                            s_state.startpos = jTextArea1.getSelectionStart() - jTextArea1.getLineStartOffset(lineNumber);
                            s_state.endpos = jTextArea1.getSelectionEnd() - jTextArea1.getLineStartOffset(lineNumber);
                      
                            pairs.get(i).s.add(s_state);
                        }
                    }
                    col = 1;
                }
                else
                {
                    int size = pairs.size();
                    for(int i = 0 ; i < size ;i++)
                    {
                        if(pairs.get(i).linenumber == lineNumber)
                        {
                            character c_char = new character();
                            c_char.value = jTextArea1.getSelectedText();
                            c_char.startpos = jTextArea1.getSelectionStart() - jTextArea1.getLineStartOffset(lineNumber);
                            c_char.endpos = jTextArea1.getSelectionEnd() - jTextArea1.getLineStartOffset(lineNumber);
                            
                            pairs.get(i).c = c_char;
                        }
                    }
                    col = 0;
                }
                    
                
                int row = Integer.parseInt(table.get(lineNumber).toString() );
                
                String currentValue =((DefaultTableModel)jTable2.getModel()).getValueAt(row ,col).toString();
               
                if( jComboBox1.getSelectedItem().equals("States"))
                {
                    currentValue += "/" + jTextArea1.getSelectedText();
                }
                else
                    currentValue = jTextArea1.getSelectedText();
                
               ((DefaultTableModel)jTable2.getModel()).setValueAt( currentValue,row ,col);
               
               
           }
           else
           {
                Object[] data ;
               // Create a new pair
                characterStatePair p = new characterStatePair();
                
                if( jComboBox1.getSelectedItem().equals("States"))
                {
                      //Create a new state
                      states s_state = new states();
                      s_state.value = jTextArea1.getSelectedText();
                      s_state.startpos = jTextArea1.getSelectionStart() - jTextArea1.getLineStartOffset(lineNumber);
                      s_state.endpos = jTextArea1.getSelectionEnd() - jTextArea1.getLineStartOffset(lineNumber);
                      p.s.add(s_state);
                      Object[] rowData ={ "" , jTextArea1.getSelectedText() };
                      data = rowData;
                      
                }
                else
                {
                      //Create a new character
                      character c_char = new character();
                      c_char.value = jTextArea1.getSelectedText();
                      c_char.startpos = jTextArea1.getSelectionStart() - jTextArea1.getLineStartOffset(lineNumber);
                      c_char.endpos = jTextArea1.getSelectionEnd() - jTextArea1.getLineStartOffset(lineNumber);
                      p.c= c_char;
                      
                      Object[] rowData ={ jTextArea1.getSelectedText() ,"" };
                      data = rowData;
                }
               
                int startOffset = jTextArea1.getLineStartOffset(lineNumber);
                int endOffset = jTextArea1.getLineEndOffset(lineNumber);
                
                p.linenumber = lineNumber;
                p.lineContent = jTextArea1.getText(startOffset, endOffset - startOffset + 1);
                
                pairs.add(p);
                ((DefaultTableModel)jTable2.getModel()).addRow(data);
                table.put(lineNumber,rowCount);
               
                rowCount++;
           }
        } catch (BadLocationException ex) {
           System.out.print(ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    Vector<String> dataRows = new Vector<String>();
    
    private void Learn()
    {
        ReLearner myLearner = new ReLearner(dataRows, ReLearner.AlgoType.REGEX_TEMPLATE);

        Vector<Integer> startPos = new Vector<Integer>();
        Vector<Integer> endPos = new Vector<Integer>();

         for(int i = 0 ; i < pairs.size();i++)
         {
             String line = pairs.get(i).lineContent;
             character c_char = pairs.get(i).c;
             if( c_char != null)
              {
             System.out.println("\n##########Adding example for character to reLearner#########");
             myLearner.addCharacterExample(line, c_char.startpos, c_char.endpos);
              }

             for(int j = 0 ;j< pairs.get(i).s.size();j++)
             {
                 states s_state = (states) pairs.get(i).s.get(j);
                 startPos.add(s_state.startpos);
                 endPos.add(s_state.endpos);
                 myLearner.addStateExample(line.substring(s_state.startpos, s_state.endpos));
             }

             startPos.clear();
             endPos.clear();
         }
        
         jTextArea3.setText("");
             
        int startline;
        int endline ;
           
        Vector<Pairs> chAndStates = myLearner.getCharacterAndStatesUsingRegexTemplatesPair();
        
        for(int i = 0 ; i <chAndStates.size() ;i++)
        {
            Pairs p = chAndStates.get(i);
            String key= p.getChar();
            jTextArea3.setText(jTextArea3.getText()+ key +"\n");
    
            // getValue is used to get value of key in Map
            Vector<String> value=(Vector<String>)p.getStates();

            for(int j = 0 ; j< value.size();j++)
            {
                jTextArea3.setText( jTextArea3.getText()+ value.get(j) + "\n");
            }

            jTextArea3.setText(jTextArea3.getText()+ "\n");
      }
        
        Vector<String> regExs = myLearner.getRegExpr();
        String expressions ="----------- Set of Regular Expressions -------------\n";
        
        for(int i =0 ;i< regExs.size();i++)
        {
            expressions += regExs.elementAt(i);
            
            Pattern pattern = Pattern.compile(regExs.elementAt(i));
            
            expressions +="\n";
        }
        jTextArea2.setText(expressions);
           
        Marker(myLearner);

    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
              
              if(fromPdf)
              {
                  Learn();
                  return;
              }
            
              dataRows.clear();

FileInputStream fin;
try {
fin = new FileInputStream(fileinput);
DataInputStream din = new DataInputStream(fin);
BufferedReader br = new BufferedReader(new InputStreamReader(din));
String nextLine;
try {
while((nextLine = br.readLine()) != null)
dataRows.addElement(nextLine);
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
                       
                        Learn();

} catch (FileNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        jTextArea3.setText("");
        jTextArea2.setText("");
        
        int rows = ((DefaultTableModel)jTable2.getModel()).getRowCount();
        
        for(int i = 0 ;i< rows;i++)
        ((DefaultTableModel)jTable2.getModel()).removeRow(i);
      
        
        pairs.clear();
        
             Highlighter hilite = jTextArea1.getHighlighter();
                   hilite.removeAllHighlights();
               
        table.clear();
        
        rowCount = 0;
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        WordConverter word = new WordConverter(this, rootPaneCheckingEnabled);
        word.show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public class MyAdapter extends WindowAdapter
    {
        SampleJForm form;
        public MyAdapter(SampleJForm form) {
        
            this.form = form;
        }
        
    };
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
     FileDialog fileDlg = new FileDialog(this,"Select the file");
         fileDlg.show();
         
         String currFileext = fileDlg.getFile();
         if (currFileext != null)
         {
         String []token = currFileext.split("\\.");
         System.out.println(token[token.length -1]);
         
         currFileext = token[token.length -1];
        
         if (currFileext.equalsIgnoreCase("pdf"))
         {
         
//String fileName = fileDlg.getDirectory()+"//" + fileDlg.getFile();


//System.out.print(fileName);
String parsedText = null ;
PdfConverter pdf = new PdfConverter(this, rootPaneCheckingEnabled);

pdf.SetParent(this);

// add a window listener
pdf.addWindowListener(new MyAdapter(this)
{
public void windowClosed(WindowEvent e)
{
System.out.println("jdialog window closed");
if(form != null && form.GetParsedText() != null )
{
// Handle Window Closed event here

}
}

public void windowClosing(WindowEvent e)
{
System.out.println("jdialog window closing");
}
});

pdf.setFileName(fileDlg.getDirectory(), fileDlg.getFile(), evt);
pdf.show();
}
        
         else if (currFileext.equalsIgnoreCase("doc") || currFileext.equalsIgnoreCase("docx") )
         {
         WordConverter word = new WordConverter(this, rootPaneCheckingEnabled);
         word.setFileName(fileDlg.getFile(), fileDlg.getDirectory(), evt);
         word.show();
         }
        
         else
         {
         int optionType = JOptionPane.OK_OPTION;
         int messageType = JOptionPane.PLAIN_MESSAGE; // no standard icon

         final JButton ok = new JButton("ok");
         ok.addActionListener(new ActionListener() {

@Override
public void actionPerformed(ActionEvent e) {
Window w = SwingUtilities.getWindowAncestor(ok);

if (w != null) {
w.setVisible(false);
}

}
});
        
        
         Object[] selValues = { ok };

         //show dialog as normal, selected index will be returned.
         int res = JOptionPane.showOptionDialog(null, "This File format is not supported yet !",
         "Invalid File Format", optionType, messageType, null, selValues,
         selValues[0]);
        
        
         }
       }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private NexusGen block;
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
//GEN-FIRST:event_jButton4ActionPerformed
     String[] parsedLines = null;
     if(matrix != null)
     {
    	 matrix = matrix.replaceAll("\t", " ");
    	 parsedLines = matrix.split("\\n");
     }
     
     if (parsedLines.length == 1) {
    	 	StringBuilder sbr = new StringBuilder();
     	
	     	for (int i=0; i+1 < matrix.length(); i++)
	     	{
	     		
	     		if (matrix.charAt(i) == '\t')
	     			sbr.append(" ");
	     		else
	     			sbr.append(matrix.charAt(i));
	     		
	     		if (Character.isDigit(matrix.charAt(i)) && Character.isAlphabetic(matrix.charAt(i+1))) {
	     			sbr.append("\n");
	     			
	     			
	     	}
	     		
	     	parsedLines = sbr.toString().split("\n");
     		
     		//sbr.append(fileData.charAt(i+1));
     	}
     }

     //characterAndStates ( Vector<Pairs> to be passed to MatrixBlock )

     Vector<String> vectorOfLines= new Vector<String>();
     if(parsedLines != null )
     vectorOfLines.addAll(Arrays.asList(parsedLines));

     block = new NexusGen(characterAndStates, vectorOfLines, "SAMPLE");
     String tt = block.getNexusStr();

     FileDialog fileDlg = new FileDialog(this,"Open the file", FileDialog.SAVE);
     fileDlg.setFilenameFilter(new FilenameFilter() {

@Override
public boolean accept(File dir, String name) {
if(name.endsWith(".nex"))
return true;
return false;
}
});
    
     fileDlg.show();
    
     String fileName = fileDlg.getDirectory() + "//" + fileDlg.getFile();
    
     Path path = Paths.get(fileName);
    
     try {
Files.write(path, Arrays.asList(tt), java.nio.charset.StandardCharsets.UTF_8);
}
     catch (IOException e) {
e.printStackTrace();
}
    
     System.out.print(fileName);
         
     System.out.println(tt);
         
         
         
    }//GEN-LAST:event_jButton4LPerformed
 
    public void RemoveNoiseClicked()
    {
       System.out.print(parsedText);
    }
    
    private String parsedText ;
    private boolean fromPdf = false;
    
    private String matrix;
  
    public void SetMatrix(String Matrix)
    {
        matrix = Matrix;
    }

    private Vector<Pairs> characterAndStates = null;
    public void setCharacterAndStates(Vector<Pairs> chAndStates) {
     characterAndStates = chAndStates;
    }
    
    public void SetParsedText(String text)
    {
        jTextArea1.setText(text);
    }
    public void SetDataRows(Vector<String> properFormatedInput)
    {
       // this.parsedText = parsedText;
        dataRows.clear();
        fromPdf = true;
        dataRows.addAll(properFormatedInput);
    }
    
    public String GetParsedText()
    {
        return this.parsedText ;
    }
 
    void Marker(ReLearner mylearner)
    {
    Vector<Pairs> charAndStates = mylearner.getCharacterAndStatesUsingRegexTemplates();
    setCharacterAndStates(charAndStates);

               Vector<String> matchedChars = new Vector<String>();
               Vector<String> matchedStates = new Vector<String>();
               ArrayList <String> highlightChars = new ArrayList<String>();
               String extractedData = "";
               
               /* Display char and states on right side ( TextArea3 )*/
               for(int i=0;i<charAndStates.size();i++)
               {
                matchedChars.add(charAndStates.elementAt(i).character);
                //System.out.println("****Character is"+charAndStates.elementAt(i).character+"*******");
                extractedData += ( i + "." + charAndStates.elementAt(i).character + "\n");
                String []tokens = matchedChars.elementAt(i).split("\\d\\.\\s");
                
                if (tokens != null && tokens.length >= 2) {
                	highlightChars.add(tokens[1].toString());

                }
                	

                Vector<String> st = charAndStates.elementAt(i).states;
                for(int j=0;j<st.size();j++)
                {
                    if (!st.elementAt(j).equalsIgnoreCase("")) 
                    	matchedStates.add(st.elementAt(j));
                    extractedData += ( "\t" + st.elementAt(j) + "\n");
                }
                extractedData += "\n";
               }
               jTextArea3.setText(extractedData);
               System.out.println(extractedData);
			   jTextArea3.setEditable(true);
               
               for (int i = 0; i< highlightChars.size();i++)
               {
            	   int startpos = 0 ;
                   int lastpos = 0;
            	   String matchingChar = highlightChars.get(i);
            	   startpos = jTextArea1.getText().indexOf(matchingChar);
            	   lastpos = jTextArea1.getText().lastIndexOf(matchingChar);
                   
                   
                   if( startpos>=0 )
                   {
                       Highlighter hilite = jTextArea1.getHighlighter();
                       Highlighter.HighlightPainter p = new DefaultHighlighter.DefaultHighlightPainter(Color.yellow);
                       try {
                    	   hilite.addHighlight(startpos, startpos+highlightChars.get(i).length(), p);
                    	   
                    	   if (lastpos != startpos)
                    		   hilite.addHighlight(lastpos, lastpos+highlightChars.get(i).length(), p);
                    	   
                       } catch (BadLocationException ex) {
                    	   Logger.getLogger(SampleJForm.class.getName()).log(Level.SEVERE, null, ex);
                       }
                   }
                   
               }
               
               /* Highlight text areas into yellow and green based on character/state */
               /*for(int i = 0 ;i< matchedChars.size();i++)
               {
                   int startpos = 0 ;
                   while(true)
                   {
                       startpos = jTextArea1.getText().indexOf(matchedChars.elementAt(i),startpos+1);
                   
                   if( startpos>=0 )
                   {
                       Highlighter hilite = jTextArea1.getHighlighter();
                       Highlighter.HighlightPainter p = new DefaultHighlighter.DefaultHighlightPainter(Color.yellow);
               try {
                   hilite.addHighlight(startpos, startpos+matchedChars.elementAt(i).length(), p);
               } catch (BadLocationException ex) {
                   Logger.getLogger(SampleJForm.class.getName()).log(Level.SEVERE, null, ex);
               }
                   }
                   else
                       break;
                           
                   }
              }*/
        
               /* HighLight states for every character */
               for(int i = 0 ;i< matchedStates.size();i++)
               {
                   int startpos = 0 ;
                   while(true)
                   {
                       startpos = jTextArea1.getText().indexOf(matchedStates.elementAt(i),startpos+1);
                   
                   if( startpos>=0 )
                   {
                       Highlighter hilite = jTextArea1.getHighlighter();
                       Highlighter.HighlightPainter p = new DefaultHighlighter.DefaultHighlightPainter(Color.green);
               try {
                   hilite.addHighlight(startpos, startpos+matchedStates.elementAt(i).length(), p);
               } catch (BadLocationException ex) {
                   Logger.getLogger(SampleJForm.class.getName()).log(Level.SEVERE, null, ex);
               }
                   }
                   else
                       break;
                           
                   }
                   
              }
               
              System.out.println("CharAndStates have "+charAndStates.size()+" elements");
             
    }
         
     void LoadContents(String fileName)
     {
       try
         {
         FileInputStream fin = new FileInputStream(fileName);

DataInputStream in = new DataInputStream(fin);
BufferedReader br = new BufferedReader(new InputStreamReader(in));

         String fileContents ="" , strLine ;
         while((strLine = br.readLine())!=null)
{
            fileContents+= strLine;
            fileContents += "\n" ;
         }
         
         jTextArea1.setText(fileContents);
         }
         catch (Exception e )
         {
             ;
         }
     }
     
    /**
* @param args the command line arguments
*/
    public static void main(String args[]) {
        /*
* Set the Nimbus look and feel
*/
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
* If Nimbus (introduced in Java SE 6) is not available, stay with the
* default look and feel. For details see
* http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
*/
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SampleJForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SampleJForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SampleJForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SampleJForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
* Create and display the form
*/
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new SampleJForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    // End of variables declaration//GEN-END:variables
}