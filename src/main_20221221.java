//import java.awt.BorderLayout;
import javax.swing.JFileChooser;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FileChooserUI;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import javax.swing.LayoutStyle.ComponentPlacement;

public class main_20221221 extends JFrame {

	private static final FileChooserUI JFileChooser = null;
	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_20221221 frame = new main_20221221();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public main_20221221() throws IOException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(main_20221221.class.getResource("/image/icon.jpg")));
		
		
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setResizable(false);
		setTitle("LOG_parser  2022.12.21");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 299);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(153, 102, 153));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		final javax.swing.JFileChooser choise = new JFileChooser();
		//choise.setCurrentDirectory(choise.getSelectedFile()); 記憶上次選擇目錄
		//choise.setCurrentDirectory(new File(getPath()));  //當下jar位置
		
		File dirctory = new File("");
		String courseFile = dirctory.getCanonicalPath();
		
		
		final String path= courseFile+"\\LOG_parser.exe";
		choise.setCurrentDirectory(new File(path));
		System.out.print(path);
		
		//choise.setCurrentDirectory(new File(ClassLoader.getSystemResource("LOG_parser.exe")));  //當下jar位置
		
		//String road=getPath();
		//String road=System.getProperty("LOG_parser.exe");
		//System.out.print(System.getProperty("LOG_parser.exe"));
		//choise.setCurrentDirectory(new File(road));		
		//choise.setCurrentDirectory(new File(System.getProperty("LOG_parser.exe"))); //包EXE抓開起路徑用
		
		JPanel panel = new JPanel();
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	
		
		
		
		Random range = new Random();
		int ran =(range.nextInt(2)+1);

		//ImageIcon icon1=new ImageIcon("src/image/image"+ran+".gif");
		 ImageIcon icon1=new ImageIcon(Toolkit.getDefaultToolkit().getImage(main_20221221.class.getResource("/image/image"+ran+".gif")));
		
        //新增JLabel 放置圖片
        JLabel label1=new JLabel(icon1);
        //設定label的位置、大小，label大小為圖片的大小
        //Random range = new Random();
        //int aa= range.nextInt(100)+0;
        
        int ran1 =(range.nextInt(200)-50);
        if(ran==1) label1.setBounds(ran1,ran1,icon1.getIconWidth(),icon1.getIconHeight());	
        else       label1.setBounds(0,0,icon1.getIconWidth(),icon1.getIconHeight());
        //JFrame框架
        //JFrame frame=new JFrame();
        //在frame的底層容器新增label
        getLayeredPane().add(label1,new Integer(Integer.MIN_VALUE));
        //panel
        //JPanel panel1 =new JPanel();

        //---------------
      
          
        //ImageIcon icon2=new ImageIcon("src/image/background1.jpg");
        ImageIcon icon2=new ImageIcon(Toolkit.getDefaultToolkit().getImage(main_20221221.class.getResource("/image/background1.jpg")));
        
        //新增JLabel 放置圖片
        JLabel label2=new JLabel(icon2);
        //設定label的位置、大小，label大小為圖片的大小
        label2.setBounds(0,0,550,400);
        
        
        //JFrame框架
        //JFrame frame=new JFrame();
        //在frame的底層容器新增label
        getLayeredPane().add(label2,new Integer(Integer.MIN_VALUE));
        setLocationRelativeTo(null);// 居中顯示
        setVisible(true);
        
        //---------------
        
        

        //panelTop，頂層容器
        JPanel panelTop=new JPanel();
        panelTop=(JPanel)getContentPane();

        //panel和panelTop設定透明
        panelTop.setOpaque(false);
        panel.setOpaque(false);

        //label0，這個是對介面的自定義操作，用作效果展示
        //JLabel label0=new JLabel("這是一個Label");
        //panel.add(label0);

        //新增panel，設定大小，可視
        //getContentPane().add(panel);
        setSize(539, 346);
        setVisible(true);
        
		
//-------------------------------------------------------------
		//CAN parser button
		JButton CAN_Button = new JButton("CAN");
		CAN_Button.setSelectedIcon(new ImageIcon(main_20221221.class.getResource("/image/icon.jpg")));
		CAN_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				FileNameExtensionFilter ff = new FileNameExtensionFilter( null, "LOG");  
				choise.setFileFilter(ff);  
				
				
				int flag = choise.showOpenDialog(frame);
				if (flag == choise.APPROVE_OPTION) 				
				try {
					main2(choise.getSelectedFile().getPath());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
		
		
		
		//ME parser button
		JButton ME_Button = new JButton("ME");
		ME_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame frame = new JFrame();
				FileNameExtensionFilter ff = new FileNameExtensionFilter( null, "LOG");  
				choise.setFileFilter(ff);  
				
				int flag = choise.showOpenDialog(frame);
				if (flag == choise.APPROVE_OPTION) 

				//System.out.println("使用者選擇了檔案：" + choise.getSelectedFile().getPath());
				
				try {
					main1(choise.getSelectedFile().getPath());
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
		
		//Siemens parser button
		JButton Siemens_Button = new JButton("\u897F\u9580\u5B50");
		Siemens_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame frame = new JFrame();
				FileNameExtensionFilter ff = new FileNameExtensionFilter( null, "LOG");  
				choise.setFileFilter(ff);  
				
				int flag = choise.showOpenDialog(frame);
				if (flag == choise.APPROVE_OPTION) 

				//System.out.println("使用者選擇了檔案：" + choise.getSelectedFile().getPath());
				
				try {
					main4(choise.getSelectedFile().getPath());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}					
			}
		});
		
		//自動辨識LOG 使用 Parser格式 BUTTON
		JButton Siemens_Button_1 = new JButton("\u81EA\u52D5\u8FA8\u8B58");
		Siemens_Button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame frame = new JFrame();
				FileNameExtensionFilter ff = new FileNameExtensionFilter( null, "LOG");  
				choise.setFileFilter(ff);  
				
				int flag = choise.showOpenDialog(frame);
				if (flag == choise.APPROVE_OPTION) 

				//System.out.println("使用者選擇了檔案：" + choise.getSelectedFile().getPath());
				
				try {
					main6(choise.getSelectedFile().getPath());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					//System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXX");
				}			
				
			}
		});
		
		//CAN.ME重複_BUTTON
		JButton Repeat_Button = new JButton("Repeat");
		Repeat_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				
				//限制開起的副檔名
				//FileNameExtensionFilter ff = new FileNameExtensionFilter( null, "txt");  
				//choise.setFileFilter(ff);  
				
				int flag = choise.showOpenDialog(frame);
				if (flag == choise.APPROVE_OPTION) 

				//System.out.println("使用者選擇了檔案：" + choise.getSelectedFile().getPath());
				
				try {
					main3(choise.getSelectedFile().getPath());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}					
				
			}
		});
		
		//西門子重複 BUTTON
		JButton Siemens_Repeat_Button = new JButton("\u897F\u9580\u5B50Repeat");
		
		JButton btnNewButton = new JButton("原廠機加速讀數據用");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				FileNameExtensionFilter ff = new FileNameExtensionFilter( null, "TXT");  
				choise.setFileFilter(ff);  
				
				
				int flag = choise.showOpenDialog(frame);
				if (flag == choise.APPROVE_OPTION) 				
				try {
					main7(choise.getSelectedFile().getPath());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(CAN_Button)
							.addGap(5)
							.addComponent(ME_Button)
							.addGap(5)
							.addComponent(Siemens_Button)
							.addGap(5)
							.addComponent(Siemens_Button_1)
							.addGap(5)
							.addComponent(Repeat_Button)
							.addGap(5)
							.addComponent(Siemens_Repeat_Button)))
					.addGap(24))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(CAN_Button)
						.addComponent(ME_Button)
						.addComponent(Siemens_Button)
						.addComponent(Siemens_Button_1)
						.addComponent(Repeat_Button)
						.addComponent(Siemens_Repeat_Button))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addContainerGap(241, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		Siemens_Repeat_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame frame = new JFrame();
				
				//限制開起的副檔名
				//FileNameExtensionFilter ff = new FileNameExtensionFilter( null, "txt");  
				//choise.setFileFilter(ff);  
				
				int flag = choise.showOpenDialog(frame);
				if (flag == choise.APPROVE_OPTION) 

				//System.out.println("使用者選擇了檔案：" + choise.getSelectedFile().getPath());
				
				try {
					main5(choise.getSelectedFile().getPath());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
				
			}
		});
		//contentPane.setLayout(gl_contentPane);
			
	}
	
	
//-------------------------------------------------------------	
	
	
	//get jar執行檔路徑
	public static String getPath(){
		String filePath = System.getProperty("java.class.path");
		String pathSplit = System.getProperty("path.separator");//windows下是";",linux下是":"
		
		if(filePath.contains(pathSplit)){
			filePath = filePath.substring(0,filePath.indexOf(pathSplit));
		}else if (filePath.endsWith(".jar")) {//擷取路徑中的jar包名,可執行jar包執行的結果裡包含".jar"
			
			filePath = filePath.substring(0, filePath.lastIndexOf(File.separator) + 1);
			
		}
		return filePath;
	}
	
	
	
	
	//ME parser
	public static void main1(String filename) throws IOException {
		
		 filename= filename.substring(0,filename.length()-4);		
		 FileReader fr = new FileReader(filename+".LOG");
		 FileWriter fw = new FileWriter(filename+"_ME.txt");
		 FileWriter nouse_send = new FileWriter(filename+"_ME_Not.txt");
		
		 //String filename="BMW_E_DIAG_3FC0C_20210428120501";
		 //FileReader fr = new FileReader("C:\\Users\\AutoUser\\Desktop\\java readwrite test\\bmwE_parser\\"+filename+".LOG");
		 //FileWriter fw = new FileWriter("C:\\Users\\AutoUser\\Desktop\\java readwrite test\\bmwE_parser\\"+filename+".txt");
		 //FileWriter nouse_send = new FileWriter("C:\\Users\\AutoUser\\Desktop\\java readwrite test\\bmwE_parser\\"+filename+"_Not.txt");
		 BufferedReader BR = new BufferedReader(fr);
		 String line="";
		 String save="";
		 String SP[];
		 String send="";
		 String resp="";
		 String check_send="";
		 String check_resp="";
		 String send_change="";
		 String resp_change="";
		 String addr="error";
		 int send_len=0;
		 int i=0;
		 String cmd_send_len;
		 String cmd_resp_len;
		 int addrtoint=-100;
		 
		 
		 String broadcast_send[] = null;
		 String broadcast_resp[];
		 String check_protoclo="";
		 ArrayList send_arrlist = new ArrayList();
		 ArrayList resp_arrlist = new ArrayList();
		 
		 while((line=BR.readLine()) != null)
		 {
			 
			 if(line.contains("ME protoclo ECU"))
			 check_protoclo="ME protoclo ECU";
			 if(line.contains("CAN protoclo ECU"))
			 check_protoclo="CAN protoclo ECU";
			
			 if(check_protoclo.equals("CAN protoclo ECU"))
			 {
				 if(line.contains("W:")||line.contains("R:"))
				 {
					 if(line.contains("W:"))
					 {
						 line=line.substring(2,line.length()-1);
						 broadcast_send=line.split(" ");
					 }
					 else if(line.contains("R:"))
					 {
						 line=line.substring(5,line.length()-4);
						 broadcast_resp=line.split(" ");
						 //System.out.print(broadcast_send[3]);
						
						 
							 for(int k=0; k<broadcast_resp.length;k++)
							 resp_arrlist.add(broadcast_resp[k]);
						
							 while(resp_arrlist.size()>1)
							 {
							 
							 addrtoint= ((Integer.decode("0x"+resp_arrlist.get(0)+resp_arrlist.get(1))-0xc000)/32);
							 
							 for(int k=1; k<=broadcast_send.length-1;k++)
							 send_change+="0x"+broadcast_send[k]+", ";
							 
							 for(int k=5; k<=Integer.decode("0x"+resp_arrlist.get(5))+5;k++)
							 resp_change+="0x"+resp_arrlist.get(k)+", ";
							 
							 int len=Integer.decode("0x"+resp_arrlist.get(5));
							 for(int k=0; k<=len+5;k++) 
							 resp_arrlist.remove(0);
							 
							 //System.out.println(resp_arrlist.toString());
							 //System.out.println(Integer.valueOf(broadcast_resp[5],16));
							 //System.out.println(send_change);
							 //System.out.println(resp_change+"\n");	 
							 
							 if(addrtoint==-100)
							 {
								 fw.write("	"+"{"+"\r\n");
								 fw.write("		 "+"null"+", "+send_change+"\r\n");
								 fw.write("		 "+"null"+", "+resp_change.substring(0,resp_change.length()-2)+"\r\n");
								 fw.write("	"+"},"+"\r\n");
							 }
							 else
							 {
								 fw.write("	"+"{"+"\r\n");
								 fw.write("		 "+"0x"+String.format("%02X", addrtoint)+", "+send_change+"\r\n");
								 fw.write("		 "+"0x"+String.format("%02X", addrtoint)+", "+resp_change.substring(0,resp_change.length()-2)+"\r\n");
								 fw.write("	"+"},"+"\r\n");
							 }
							 
							 send_change="";
							 resp_change="";
						 }
							 send_arrlist.clear();
							 resp_arrlist.clear();
							 check_protoclo="";
					 } 
				 }	 
			 }
			 else if(check_protoclo.equals("ME protoclo ECU"))
			 {
				 if(line.contains("W:")||line.contains("R:"))
				 {
					 if(line.contains("W:"))
					 {
						 line=line.substring(11,line.length()-4);
						 broadcast_send=line.split(" ");
					 }
					 else if(line.contains("R:"))
					 {
						 line=line.substring(5,line.length()-4);
						 broadcast_resp=line.split(" ");
						 //System.out.print(broadcast_send[3]);
						
						 
							 for(int k=0; k<broadcast_resp.length;k++)
							 resp_arrlist.add(broadcast_resp[k]);
							 //System.out.print(resp_arrlist.toString());					
							 
							 while(resp_arrlist.size()>1)
							 {
							 
							 addrtoint= ((Integer.decode("0x"+resp_arrlist.get(0)+resp_arrlist.get(1))-0xc000)/32);
							 
							 for(int k=0; k<=broadcast_send.length-1;k++)
							 send_change+="0x"+broadcast_send[k]+", ";
							 
							 
							 resp_arrlist.add(4,String.format("%02X", Integer.decode("0x"+resp_arrlist.get(1))-0x80));
							 
							 for(int k=3; k<=Integer.decode("0x"+resp_arrlist.get(4))+4;k++)
							 resp_change+="0x"+resp_arrlist.get(k)+", ";
							 					 
							 //System.out.println(resp_arrlist.toString());
							 //System.out.println(Integer.valueOf(broadcast_resp[5],16));
							 //System.out.println("0x"+resp_arrlist.get(3)+", 0x02, "+send_change);
							 //System.out.println(resp_change+"\n");	 
							 
			
							 fw.write("	"+"{"+"\r\n");
							 fw.write("		 "+"0x"+resp_arrlist.get(3)+", 0x02, "+send_change+"\r\n");
							 fw.write("		 "+resp_change.substring(0,resp_change.length()-2)+"\r\n");
							 fw.write("	"+"},"+"\r\n");		 
							 				 
							 int len=Integer.decode("0x"+resp_arrlist.get(4));
							 for(int k=0; k<=len+4;k++) 
							 resp_arrlist.remove(0);
							 
							 send_change="";
							 resp_change="";
						 }
							 send_arrlist.clear();
							 resp_arrlist.clear();
							 check_protoclo="";
					 } 
				 }	 
			 }
			//存send/resp命令
			 else if(line.contains("55AA")||line.contains("AA55"))
			 {
				 i+=1;
				 if(line.contains("55AA"))
				 send=line.substring(line.indexOf("55AA"),line.length());
				 else if(line.contains("AA55"))
				 resp=line.substring(line.indexOf("AA55"),line.length());
			 
				 /*
				 if(i%2!=0)send=save;  
				 else resp=save;
			 	 */
			 
				 //判斷存到resp後動作
				 if(resp.length()>0) 
				 {
					 if(send.contains("DE200000"))
						 //System.out.println(send.lastIndexOf("DE200000"));
					 {
						   int ecu_len=send.lastIndexOf("DE200000")+7;
						   addr=(send.charAt(ecu_len+1)+""+send.charAt(ecu_len+2)+""+send.charAt(ecu_len+3)+""+send.charAt(ecu_len+4))+"";
						   //addr=(send.charAt(32)+""+send.charAt(33)+""+send.charAt(34)+""+send.charAt(35))+"";
						   addrtoint= ((Integer.decode("0x"+addr)-0xc000)/32);  // ecu address
					 }
					 	
				         if(resp.contains("AA554200"))
						 {
				        	 check_send=send;
				        	 check_resp=resp;
							 //send=send.substring(6,send.length());   
							 //resp=resp.substring(8,resp.length());
							 send=send.substring(6,send.length()-4);   
							 resp=resp.substring(8,resp.length()-4);
							 
							 for(int k=0; k<send.length()-1; k+=2)
							 {
								 send_arrlist.add(send.charAt(k)+""+send.charAt(k+1));
								 
							 }
							 for(int k=0; k<resp.length()-1; k+=2)
							 {
								 resp_arrlist.add(resp.charAt(k)+""+resp.charAt(k+1));
							 }
							 
							 /*
							 cmd_send_len=String.format("%02X", send_arrlist.size());
							 System.out.print(send_arrlist.get(0));
							 send_arrlist.set(1, cmd_send_len);
							 cmd_resp_len=String.format("%02X", resp_arrlist.size());
							 resp_arrlist.add(1, cmd_resp_len);
							 */
							 					 
							 if(check_send.contains("55AA0280"))
							 {
								 send_arrlist.remove(0);
								 send_arrlist.remove(1);
							 }
							 else 
							 {
								 send_arrlist.set(2, String.format("%02X", Integer.decode("0x"+send_arrlist.get(0))-0x80));
								 send_arrlist.remove(0);
							 }
							 if(check_resp.contains("AA55420080"))
							 {
								 resp_arrlist.remove(0);
								 resp_arrlist.remove(0);
							 }
							 else
							 {
								 resp_arrlist.add(3, String.format("%02X", Integer.decode("0x"+resp_arrlist.get(0))-0x80));
								 resp_arrlist.remove(0);
								 resp_arrlist.remove(0); 
							 }
							 
							 
							 for(int k=0; k<send_arrlist.size(); k++)
							 {
								send_change+="0x"+send_arrlist.get(k)+", ";
							 }
							 for(int k=0; k<resp_arrlist.size(); k++)
							 {
								resp_change+="0x"+resp_arrlist.get(k)+", ";
							 }		 
							 
							 fw.write("	"+"{"+"\r\n");
							 fw.write("		 "+send_change+"\r\n");
							 fw.write("		 "+resp_change.substring(0,resp_change.length()-2)+"\r\n");
							 fw.write("	"+"},"+"\r\n");
							 
							 send_arrlist.clear();
							 resp_arrlist.clear();
						 } 
					 else
					 {
						 nouse_send.write(send+"\n");
						 nouse_send.write(resp+"\n");
					 }
					 send="";
					 resp="";
					 check_send="";
					 check_resp="";
					 send_change="";
					 resp_change="";
					 send_len=0;
				 }
			 }		 
			 nouse_send.flush();
			 fw.flush();
		 }
		 nouse_send.flush();
		 fw.flush();  // flush 強致將緩衝區發出去
		 fr.close();
		}
	
	//CAN parser
	public static void main2(String filename) throws IOException {
		 filename= filename.substring(0,filename.length()-4);		
		 FileReader fr = new FileReader(filename+".LOG");
		 FileWriter fw = new FileWriter(filename+"_CAN.txt");
		 FileWriter nouse_send = new FileWriter(filename+"_CAN_Not.txt");
		
		 /*
		 String filename="BMW_E_DIAG_403F7_20210805114950";
		 FileReader fr = new FileReader("C:\\Users\\AutoUser\\Desktop\\java readwrite test\\bmwE_parser\\"+filename+".LOG");
		 FileWriter fw = new FileWriter("C:\\Users\\AutoUser\\Desktop\\java readwrite test\\bmwE_parser\\"+filename+".txt");
		 FileWriter nouse_send = new FileWriter("C:\\Users\\AutoUser\\Desktop\\java readwrite test\\bmwE_parser\\"+filename+"_not.txt");
		 */
		 BufferedReader BR = new BufferedReader(fr);
		 String line="";
		 String save="";
		 String SP[];
		 String send="";
		 String resp="";
		 String send_change="";
		 String resp_change="";
		 String addr="error";
		 int i=0;
		 int addrtoint=-100;
		 //String addrtoint="null";
		 //fw.write("uint8[][] bmwme_cmd =\n"+"{\n");
		 
		 while((line=BR.readLine()) != null)
		 {
			 //存send/resp命令
			 //1783992313 ms:    1:8955AA0203223F0000 -> 55AA0203223F00
			 //1783992346 ms:   33:9CAA554200010013623F000241341995943FC27555413410AE1CF75C -> AA554200010013623F000241341995943FC27555413410AE1CF7

			 if(line.contains("55AA")||line.contains("AA55"))
			 {
				 i+=1;
				 if(line.contains("55AA"))
				 {
					 send=line.substring(line.indexOf("55AA"),line.length());
				 }	 
				 else if(line.contains("AA55"))
				 {
					 resp=line.substring(line.indexOf("AA55"),line.length());
				 }
				 
				 //if(i%2!=0)send=save;  
				 //else resp=save;
				 
				 //判斷存到resp後動作
				 if(resp.length()>0) {
				
				 //抓address命令
				 if(send.contains("DE200000"))
					 //System.out.println(send.lastIndexOf("DE200000"));
				 {
					   int ecu_len=send.lastIndexOf("DE200000")+7;
					   addr=(send.charAt(ecu_len+1)+""+send.charAt(ecu_len+2)+""+send.charAt(ecu_len+3)+""+send.charAt(ecu_len+4))+"";
					   //addr=(send.charAt(32)+""+send.charAt(33)+""+send.charAt(34)+""+send.charAt(35))+"";
					   addrtoint= ((Integer.decode("0x"+addr)-0xc000)/32);  // ecu address
				 }
				 //System.out.println("/"+addr); // test ecu
				 			 
				 
				 // 轉AA5542000100部分 
					 //System.out.println(resp1.substring(0,8)); // test ecu
					 if(resp.contains("AA5542000100"))
					 {
						 send=send.substring(6,send.length()-2);
						 resp=resp.substring(12,resp.length()-2);

						 for(int k=0; k<send.length()-1; k++)
						 {
							 if(k%2==0)
							 {
								 send_change+="0x"+send.charAt(k)+send.charAt(k+1)+", ";
							 }
						 }
						 for(int k=0; k<resp.length()-1; k++)
						 {
							 if(k%2==0)
							 {
								 resp_change+="0x"+resp.charAt(k)+resp.charAt(k+1)+", ";
							 }
						 }		 
						 
						 if(addrtoint==-100)
						 {
							 fw.write("	"+"{"+"\r\n");
							 fw.write("		 "+"null"+", "+send_change+"\r\n");
							 fw.write("		 "+"null"+", "+resp_change.substring(0,resp_change.length()-2)+"\r\n");
							 fw.write("	"+"},"+"\r\n");
						 }
						 else
						 {
							 fw.write("	"+"{"+"\r\n");
							 fw.write("		 "+"0x"+String.format("%02X", addrtoint)+", "+send_change+"\r\n");
							 fw.write("		 "+"0x"+String.format("%02X", addrtoint)+", "+resp_change.substring(0,resp_change.length()-2)+"\r\n");
							 fw.write("	"+"},"+"\r\n");
						 }
						 
					 }
					 else if(send.contains("55AA0203"))
					 {
						 send=send.substring(6,send.length()-2);
						 resp=resp.substring(6,resp.length());
						 
						 int check_resp_length=(resp.length())/2;
						 for(int k=0; k<send.length()-1; k++)
						 {
							 if(k%2==0)
							 {
								 send_change+="0x"+send.charAt(k)+send.charAt(k+1)+", ";
							 }
						 }
						 for(int k=0; k<resp.length()-1; k++)
						 {
							 if(k%2==0)
							 {
								 resp_change+="0x"+resp.charAt(k)+resp.charAt(k+1)+", ";
							 }
						 }	
						 fw.write("	"+"{"+"\r\n");
						 fw.write("		 "+"0x"+String.format("%02X", addrtoint)+", "+send_change+"\r\n");
						 fw.write("		 "+"0x"+String.format("%02X", addrtoint)+", 0x"+String.format("%02X", check_resp_length)+", "+resp_change.substring(0,resp_change.length()-2)+"\r\n");
						 fw.write("	"+"},"+"\r\n");
						 
					 }
					 else
					 {
						 nouse_send.write(send+"\n");
						 nouse_send.write(resp+"\n");
					 }
					 send="";
					 resp="";
					 send_change="";
					 resp_change="";
				 }
			 }		 
			 nouse_send.flush();
			 fw.flush();
		 }
		 fr.close();
		}

	//CAN.ME repeat
	public static void main3(String filename) throws IOException {
		 //filename= filename.substring(0,filename.length()-4);		
		 FileReader fr = new FileReader(filename);
		 FileWriter fw = new FileWriter(filename+"_filter");
		
		 /*
		 String filename="BMWF_DIAG_3FE12_20220209150009";
		 FileReader fr = new FileReader("C:\\Users\\AutoUser\\Desktop\\java readwrite test\\bmwF_parser\\"+filename+".txt");
		 FileWriter fw = new FileWriter("C:\\Users\\AutoUser\\Desktop\\java readwrite test\\bmwF_parser\\"+filename+".txt_filter");
		 */
		
		 BufferedReader BR = new BufferedReader(fr);
		 HashMap<String, Integer> Hashcheck = new HashMap<>(); 
		 String line="";
		 String save="";
		 String SP[];
		 String send="";
		 String resp="";
		 int i=0;
		  
		 while((line=BR.readLine()) != null)
		 {
			 if(line.contains("0x"))
			 {
				 i+=1;
				 if(i%2!=0)
				 {
					 send=line;
					 //System.out.println(send);
				 }
				 else 
				 {
					 resp=line;
					 if(!(Hashcheck.containsKey(send)))
					 {
						 fw.write("	"+"{"+"\r\n");
						 fw.write(send+"\r\n");
						 fw.write(resp+"\r\n");
						 fw.write("	"+"},"+"\r\n");
						 Hashcheck.put(send, i);
					 }
				 }
			 }
			 fw.flush();
		 }
		 fw.flush();
		 fr.close();
	}
	
	//西門子 Parser
	public static void main4(String filename) throws IOException {
		
		 filename= filename.substring(0,filename.length()-4);		
		 FileReader fr = new FileReader(filename+".LOG");
		 FileWriter fw = new FileWriter(filename+"_西門子.txt");
		 FileWriter nouse_send = new FileWriter(filename+"_西門子_Not.txt");
     /*		 
	 String filename="範例西門子";
	 FileReader fr = new FileReader("C:\\Users\\AutoUser\\Desktop\\java readwrite test\\bmwE_parser\\"+filename+".LOG");
	 FileWriter fw = new FileWriter("C:\\Users\\AutoUser\\Desktop\\java readwrite test\\bmwE_parser\\"+filename+".txt");
	 FileWriter nouse_send = new FileWriter("C:\\Users\\AutoUser\\Desktop\\java readwrite test\\bmwE_parser\\"+filename+"_Not.txt");
	 */
		 
	 BufferedReader BR = new BufferedReader(fr);
	 String line="";
	 String save="";
	 String SP[];
	 String send="";
	 String resp="";
	 String send_change="";
	 String resp_change="";
	 String addr="error";
	 int send_len=0;
	 int i=0;
	 fw.write("[CONFIG]\r\n");
	 fw.write("PROTOCOL 2\r\n"); 
	 fw.write("BAUDRATE 9600\r\n");
	 fw.write("INTER_BYTE_DELAY 1\r\n");
	 fw.write("INTER_PACKET_DELAY 140\r\n");
	 fw.write("MULTI_RES_DELAY 0\r\n");
	 fw.write("P1_MAX 25\r\n");
	 fw.write("PACKET_FORMAT 0\r\n");
	 fw.write("CHECKSUM_FORMAT 3\r\n");
	 fw.write("SYSTEM 0\r\n");
	 fw.write("PIN_NUMBER 8\r\n");
	 fw.write("[DEFINE_ECU]\r\n");
	 
	 while((line=BR.readLine()) != null)
	 {
		 //存send/resp命令 
		 if(line.contains("55AA")||line.contains("AA55"))
		 {
			 i+=1;
			 if(line.contains("55AA"))
			 send=line.substring(line.indexOf("55AA"),line.length());
			 else if(line.contains("AA55"))
			 resp=line.substring(line.indexOf("AA55"),line.length());
			 
			 /*
			 if(i%2!=0)send=save;  
			 else resp=save;
			  */
			 
			 //判斷存到resp後動作
			 if(resp.length()>0) {
			
				//抓address命令
			 if(send.contains("55AA02B8"))
				 //System.out.println(send.lastIndexOf("DE200000"));
			 {
				   int ecu_len=send.lastIndexOf("55AA02B8")+7;
				   addr=""+(send.charAt(ecu_len+1)+""+send.charAt(ecu_len+2));
				   //System.out.println("/"+addr); // test ecu
			 }
			 
			 // 轉AA554200B8F112部分 
				 //System.out.println(resp1.substring(0,8)); // test ecu
			       if(resp.contains("AA554200B8F1"))			 
				 {
			    	   
					 send=send.substring(4,send.length()-2); // 濾掉 55AA
					 resp=resp.substring(4,resp.length()-2); // 濾掉 AA55
					 
					 send_len=Integer.valueOf(send.substring(9,10));
					 
					 send=send.substring(2,10+send_len*2);  
					 resp=resp.substring(4,resp.length()-2);  
					 for(int k=0; k<send.length()-1; k++)
					 {
						 if(k%2==0)
						 {
							 send_change+=""+send.charAt(k)+send.charAt(k+1)+" ";
						 }
					 }
					 for(int k=0; k<resp.length()-1; k++)
					 {
						 if(k%2==0)
						 {
							 resp_change+=""+resp.charAt(k)+resp.charAt(k+1)+" ";
						 }
					 }
					 fw.write("REQUEST  "+send_change+"\r\n");
					 fw.write("RESPONSE "+resp_change.substring(0,resp_change.length()-1)+"\r\n");
					 //fw.write("REQUEST  "+addr+" "+send_change+"\r\n");
					 //fw.write("RESPONSE "+addr+" "+resp_change.substring(0,resp_change.length()-1)+"\r\n");
					 fw.write("\r\n");
				 }
			       
			       else if(resp.contains("AA554200"))
					 {
						 send=send.substring(4,send.length()); // 濾掉 55AA
						 resp=resp.substring(4,resp.length()); // 濾掉 AA55

						 send=send.substring(2,send.length()-4);   
						 resp=resp.substring(4,resp.length()-4); 
						 for(int k=0; k<send.length()-1; k++)
						 {
							 if(k%2==0)
							 {
								 send_change+=""+send.charAt(k)+send.charAt(k+1)+" ";
							 }
						 }
						 for(int k=0; k<resp.length()-1; k++)
						 {
							 if(k%2==0)
							 {
								 resp_change+=""+resp.charAt(k)+resp.charAt(k+1)+" ";
							 }
						 }
						 fw.write("REQUEST  "+send_change+"\r\n");
						 fw.write("RESPONSE "+resp_change.substring(0,resp_change.length()-1)+"\r\n");
						 fw.write("\r\n");
					 } 
					 
			       /*
			       else if(send.contains("44040040"))
					 {
						 send=send.substring(4,send.length()-2); // 濾掉 55AA
						 resp=resp.substring(4,resp.length()); // 濾掉 AA55

						 send=send.substring(2,send.length());   
						 resp=resp.substring(2,resp.length()); 
						 for(int k=0; k<send.length(); k++)
						 {
							 if(k%2==0)
							 {
								 send_change+=""+send.charAt(k)+send.charAt(k+1)+" ";
							 }
						 }
						 for(int k=0; k<resp.length(); k++)
						 {
							 if(k%2==0)
							 {
								 resp_change+=""+resp.charAt(k)+resp.charAt(k+1)+" ";
							 }
						 }
						 fw.write("REQUEST  "+send_change+"\r\n");
						 fw.write("RESPONSE "+resp_change+"\r\n");
						 fw.write("\r\n");
					 } 
					 */
			     /*
				 else
				 {
					 nouse_send.write(send+"\n");
					 nouse_send.write(resp+"\n");
				 }
				 */
			       
			      
			     else
				 {
			    	 
			    	 if(send.length()>10)
			    	 {
			    		 send=send.substring(4,send.length()-4); // 濾掉 55AA
			    	 }
			    	 else
			    	 {
			    		 send=send.substring(4,send.length());
			    	 }
					 resp=resp.substring(4,resp.length()); // 濾掉 AA55

					 send=send.substring(2,send.length());   
					 resp=resp.substring(2,resp.length()); 
					 for(int k=0; k<send.length()-1; k++)
					 {
						 if(k%2==0)
						 {
							 send_change+=""+send.charAt(k)+send.charAt(k+1)+" ";
						 }
					 }
					 for(int k=0; k<resp.length(); k++)
					 {
						 if(k%2==0)
						 {
							 resp_change+=""+resp.charAt(k)+resp.charAt(k+1)+" ";
						 }
					 }
					 fw.write("#REQUEST  "+send_change+"\r\n");
					 fw.write("#RESPONSE "+resp_change+"\r\n");
					 fw.write("\r\n");
				 }
				 
				 send="";
				 resp="";
				 send_change="";
				 resp_change="";
				 send_len=0;
			 }
			 
		 }		 
		 nouse_send.flush();
		 fw.flush();
	 }
	 fw.write("[DEFINE_END]");
	 nouse_send.flush();
	 fw.flush();  // flush 強致將緩衝區發出去
	 fr.close();
	}
	
	
	//西門子 repeat
	public static void main5(String filename) throws IOException {		
		 FileReader fr = new FileReader(filename);
		 FileWriter fw = new FileWriter(filename+"_filter");
		 
		 /*
		 String filename="範例西門子";
		 FileReader fr = new FileReader("C:\\Users\\AutoUser\\Desktop\\java readwrite test\\bmwE_parser\\"+filename+".txt");
		 FileWriter fw = new FileWriter("C:\\Users\\AutoUser\\Desktop\\java readwrite test\\bmwE_parser\\"+filename+".txt_filter");
		 */
		 
		 BufferedReader BR = new BufferedReader(fr);
		 HashMap<String, Integer> Hashcheck = new HashMap<>(); 
		 String line="";
		 String save="";
		 String SP[];
		 String send="";
		 String resp="";
		 int i=0;
		 fw.write("[CONFIG]\r\n");
		 fw.write("PROTOCOL 2\r\n"); 
		 fw.write("BAUDRATE 9600\r\n");
		 fw.write("INTER_BYTE_DELAY 1\r\n");
		 fw.write("INTER_PACKET_DELAY 140\r\n");
		 fw.write("MULTI_RES_DELAY 0\r\n");
		 fw.write("P1_MAX 25\r\n");
		 fw.write("PACKET_FORMAT 0\r\n");
		 fw.write("CHECKSUM_FORMAT 3\r\n");
		 fw.write("SYSTEM 0\r\n");
		 fw.write("PIN_NUMBER 8\r\n");
		 fw.write("[DEFINE_ECU]\r\n");
		 
		 while((line=BR.readLine()) != null)
		 {
			 if(line.contains("REQUEST")||line.contains("RESPONSE"))
			 {
				 i+=1;
				 if(i%2!=0)
				 {
					 send=line;
					 //System.out.println(send);
				 }
				 else 
				 {
					 resp=line;
					 if(!(Hashcheck.containsKey(send)))
					 {
						 fw.write(send+"\r\n");
						 fw.write(resp+"\r\n\r\n");
						 Hashcheck.put(send, i);
					 }
				 }
			 }
			 fw.flush();
		 }
		 fw.write("[DEFINE_END]");
		 fw.flush();
		 fr.close();
	}
	
	
	
	//自動辨識 
	public static void main6(String filename) throws IOException {
		 String MAIN_filename=filename;
		 filename= filename.substring(0,filename.length()-4);		
		 FileReader fr = new FileReader(filename+".LOG");
		 BufferedReader BR = new BufferedReader(fr);
		  
		 String line="";
		 String save="";
		 String SP[];
		 String send="";
		 String resp="";
		 int i=0;
	
		 while((line=BR.readLine()) != null)
		 { 
			//存send/resp命令 
			 if(line.contains("55AA")||line.contains("AA55"))
			 {
				 i+=1;
				 if(line.contains("55AA"))
				 send=line.substring(line.indexOf("55AA"),line.length());
				 else if(line.contains("AA55"))
				 resp=line.substring(line.indexOf("AA55"),line.length());
			 
				 //判斷存到resp後動作
				 if(resp.length()>0) 
				 {
					
					if(send.contains("55AA0203221010"))
					{
						if(resp.length()>10)
						{
							main2(MAIN_filename);
							fr.close();
							return;
						}
					}
					if(line.contains("CAN protoclo ECU"))
					{
							main2(MAIN_filename);
							fr.close();
							return;
					}
					if(send.contains("55AA02021A80"))
					{
						if(resp.length()>10)
						{
							main2(MAIN_filename);
							fr.close();
							return;
						}
					}
					
					if(send.contains("F1221010"))
					{
						if(resp.length()>10)
						{
							main1(MAIN_filename);
							fr.close();
							return;
						}
					}
					if(line.contains("ME protoclo ECU"))
					{
							main1(MAIN_filename);
							fr.close();
							return;
					}
					if(send.contains("55AA02440400"))
					{
						if(resp.length()>10)
						{
							main4(MAIN_filename);
							fr.close();
							return;
						}
					}
					if(resp.contains("AA554200B8F1"))
					{						
						main4(MAIN_filename);
						fr.close();
						save="";
						send="";
						resp="";
						return;							
					}
					 	if(resp.contains("AA5542000100"))
						{						
							main1(MAIN_filename);
							fr.close();
							save="";
							send="";
							resp="";
							return;							
						}
					 	
				 }
			 }	 
		 }
		 main2(MAIN_filename);
		 fr.close();
		 save="";
		 send="";
		 resp="";
		 return;
		 //JOptionPane.showMessageDialog(null, "無相應格式可轉檔", "錯誤提示", JOptionPane.ERROR_MESSAGE);
		 //fr.close();
	}
	
	
	
// 簡易數據
	public static void main7(String filename) throws IOException {
		
		
		 filename= filename.substring(0,filename.length()-4);		
		 FileReader fr = new FileReader(filename+".TXT");
		 FileWriter fw = new FileWriter(filename+"_NEW.txt");
		
		 HashMap<String, String> hash = new HashMap<>();
		 ArrayList<String> list= new ArrayList<>();
		 BufferedReader BR = new BufferedReader(fr);
	     String line;
	     String sp [];
	     String sp1 [];
	     String Result = "";
	     String addr;
	     String send;
	     String resp;
	     
		 while((line=BR.readLine()) != null)
		 {
			 if(line.length()<22 && line.length()>19)
			 {
				 send="";
				 resp="";
				 addr=line.substring(3,5);
				 Result=addr+" "+line.substring(9,line.length()-3);
				 sp=Result.split(" ");
				 sp1=Result.split(" ");
				 
				 if(sp[1].equals("22") && !(sp[1].equals("22") && sp[2].equals("F1") && sp[3].equals("50")))  
				 {
					 for(int i=0; i<sp.length;i++)
					 {
						 sp[i]="0x"+sp[i]+", " ;
						 if(i==1)
						 send+="0x03, ";
						 send+=sp[i];
						 
					 }
					 sp1[1]="62";
					 for(int i=0; i<sp1.length;i++)
					 {
						 sp1[i]="0x"+sp1[i]+", " ;
						 if(i==1)
						 resp+="0x03, ";
						 resp+=sp1[i];
						 
					 }
					 resp=resp.substring(0,resp.length()-2);
//					 System.out.print("	"+"{"+"\n");
//					 //resp=send.charAt(20+21)+"\n";
//					 System.out.println("		 "+send);
//					 System.out.print("		 "+resp);
//					 System.out.println();
//					 System.out.print("	"+"},"+"\n");
					 //Result+=" "+line.replace("		","").replace("\"", "").trim();
					 System.out.print("	"+"{"+"\r\n");
					 System.out.print("		 "+send+"\r\n");
					 System.out.print("		 "+resp+"\r\n");
					 System.out.print("	"+"},"+"\r\n");
					 
						fw.write("	"+"{"+"\r\n");
						fw.write("		 "+send+"\r\n");
						fw.write("		 "+resp+"\r\n");
						fw.write("	"+"},"+"\r\n");
				 }
			 }
		 }
			fr.close();
		}
	

}