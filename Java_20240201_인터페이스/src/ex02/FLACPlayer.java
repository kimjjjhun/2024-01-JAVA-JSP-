package ex02;

public class FLACPlayer implements MediaPlayer{
	private String filename;
	private Double filesize;
	private Double time;
    public static int state;  
	
	
	
	
	
	@Override
	public void play() {
		state = 1;
		System.out.println("FLAC 파일 재생 중 ...");
	}

	@Override
	public void pause() {
		state =0;
		System.out.println("일시정지");
	}

	@Override
	public void stop() {
		state =-1;
	}

	@Override
	public void file() {
		System.out.println("로드하기" + "파일명" + filename + "파일크기" + filesize + "시간" + time);
	    System.out.println("로딩중입니다....");
	}

}
