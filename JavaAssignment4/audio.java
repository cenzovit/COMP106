/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 *
 * This file contains the class which will
 * handle sound management.
 *
 */

import java.io.*;
import sun.audio.*;

public class audio{

  private AudioStream song1;
  private AudioStream song2;
  private int songPlaying;
  private int musicPaused;

  public audio(){
    InputStream stream1 = audio.class.getResourceAsStream("music/lullatonewakeup.au");
    InputStream stream2 = audio.class.getResourceAsStream("music/lullatonewander.au");
    musicPaused = 0;
    songPlaying = 1;
    try{
      song1 = new AudioStream(stream1);
      song2 = new AudioStream(stream2);
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }

  public int getPaused(){
    return musicPaused;
  }

  public void play(){
    if (songPlaying == 1){
      AudioPlayer.player.start(song1);
    }
    else{
      AudioPlayer.player.start(song2);
    }
    musicPaused = 0;
  }

  public void pause(){
    AudioPlayer.player.stop(song1);
    AudioPlayer.player.stop(song2);
    musicPaused = 1;
  }

  public void reset(){
    if(musicPaused == 0){
      pause();
      musicPaused = 0;
    }
    try{
      if(songPlaying == 1){
        InputStream stream1 = audio.class.getResourceAsStream("music/lullatonewakeup.au");
        song1 = new AudioStream(stream1);

      }
      else{
        InputStream stream2 = audio.class.getResourceAsStream("music/lullatonewander.au");
        song2 = new AudioStream(stream2);
      }	
    }
    catch(Exception e){
      e.printStackTrace();
    }
    if(musicPaused == 0){
      play();
    }
  }

  public void next(){
    pause();
    songPlaying = Math.abs(songPlaying - 1);
    reset();
    play();
  }

}
