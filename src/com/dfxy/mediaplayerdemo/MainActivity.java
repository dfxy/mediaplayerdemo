package com.dfxy.mediaplayerdemo;

import android.os.Bundle;
import android.app.Activity;  
import android.media.MediaPlayer;  
import android.view.View;  
import android.widget.ImageButton;  
import android.widget.TextView;   
public class MainActivity extends Activity 
{     
	private ImageButton mb1,mb2,mb3; 
	private TextView tv;   
	private MediaPlayer mp;   
	private boolean isPaused = false; 
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{          
		super.onCreate(savedInstanceState);          
		setContentView(R.layout.activity_main);   
		mb1 = (ImageButton)findViewById(R.id.myButton1);         
		mb2 = (ImageButton)findViewById(R.id.myButton2);         
		mb3 = (ImageButton)findViewById(R.id.myButton3);          
		tv = (TextView)findViewById(R.id.myTextView1);                     
		mp = MediaPlayer.create(this,R.raw.eyesprotecter);               
		mb1.setOnClickListener(new ImageButton.OnClickListener(){     
			@Override   
			public void onClick(View v) {     
				try {           
					if(mp != null)       
					{mp.stop();}           
					mp.prepare();       
					mp.start();       
					tv.setText("音乐播放中...");      
					} catch (Exception e) 
					{
						tv.setText("播放发生异常...");       
					    e.printStackTrace();      
					}      
				}               
			});                    
		mb2.setOnClickListener(new ImageButton.OnClickListener(){     
			@Override    
			public void onClick(View v) {      
				try {       
					if(mp !=null)      
					{   mp.stop(); 
					tv.setText("音乐停止播放...");       
					}     
					} catch (Exception e) {      
						tv.setText("音乐停止发生异常...");       
						e.printStackTrace();      
						}          
				}                   
			});                   
		mb3.setOnClickListener(new ImageButton.OnClickListener(){    
			@Override   
			public void onClick(View v) {     
				try {       
					if(mp !=null)       
					{        
						if(isPaused==false)       
						{ mp.pause();         
						isPaused=true;         
						tv.setText("停止播放!");        
						}        
						else if(isPaused==true)       
						{         
							mp.start();         
							isPaused = false;        
							tv.setText("开始播发!");        
							}       
						}      
					} catch (Exception e) {       
						tv.setText("发生异常...");       
						e.printStackTrace();     
						}           
				}                  
			});     
		mp.setOnErrorListener(new MediaPlayer.OnErrorListener()         
		{            
			@Override           
			public boolean onError(MediaPlayer arg0, int arg1, int arg2)            
			{   
				try {
					mp.release();                
					tv.setText("播放发生异常!");
					} catch (Exception e)             
					{  
						tv.setText(e.toString());                 
						e.printStackTrace();               
						}               
				return false;             
				}           
			});
		mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener()          
				{
			@Override
			public void onCompletion(MediaPlayer arg0)             
			{               
				try {                              
					mp.release();                 
					tv.setText("音乐播发结束!");               
					} catch (Exception e)               
					{ tv.setText(e.toString());  
					e.printStackTrace();               
					}             
				}           
			}); 
		
	}
	
}


