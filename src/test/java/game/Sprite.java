package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
/**
 * 스프라이트 실행영역 클래스
 * @author kimilguk
 *
 */
public class Sprite {
	protected int x; // 현재 위치의 x좌표
	protected int y; // 현재 위치의 y좌표
	protected int dx; // 단위시간에 움직이는 x방향 거리
	protected int dy; // 단위시간에 움직이는 y방향 거리
	private Image image; // 스프라이트가 가지고 있는 이미지
	boolean flag=false;

	// 생성자
	public Sprite(Image image, int x, int y) {
		this.image = image;
		this.x = x;
		this.y = y;
	}

	// 스프라이트의 가로 길이를 반환한다.
	public int getWidth() {
		return image.getWidth(null);
	}

	// 스프라이트의 세로 길이를 반환한다.
	public int getHeight() {
		return image.getHeight(null);
	}

	// 스프라이트를 화면에 그린다.
	public void draw(Graphics g) {
		g.drawImage(image, x, y, null);
	}

	// 스프라이트를 움직인다.
	public void move() {
		x += dx;
		y += dy;
	}

	// dx를 설정한다.
	public void setDx(int dx) {
		this.dx = dx;
	}

	// dy를 설정한다.
	public void setDy(int dy) {
		this.dy = dy;
	}

	// dx를 반환한다.
	public int getDx() {
		return dx;
	}

	// dy를 반환한다.
	public int getDy() {
		return dy;
 	}

	// x를 반환한다.
	public int getX() {
		return x;
	}

	// y를 반환한다.
	public int getY() {
		return y;
	}

	// 다른 스프라이트와의 충돌 여부를 계산한다. 충돌이면 true를 반환한다.
	public boolean checkCollision(Sprite other) {
		Rectangle myRect = new Rectangle();
		Rectangle otherRect = new Rectangle();
		myRect.setBounds(x, y, getWidth(), getHeight());
		otherRect.setBounds(other.getX(), other.getY(), other.getWidth(),other.getHeight());
		return myRect.intersects(otherRect);
	}

	// 내가 에일리언 총알에 충돌할 때 처리한다.
	public void handleCollision(Sprite other) {

	}
}