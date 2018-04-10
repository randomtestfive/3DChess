package randomtestfive.chess3d.core;

import java.util.Arrays;

public class Position3D {
	private final int xpos, ypos, zpos;
	private final String[] xt = new String[]{"a","b","c","d","e"};
	private final String[] yt = new String[]{"1","2","3","4","5"};
	private final String[] zt = new String[]{"A","B","C","D","E"};
	
	public Position3D(int x, int y, int z) {
		xpos = x;
		ypos = y;
		zpos = z;
	}
	
	public Position3D(String in) {
		zpos = Arrays.asList(zt).indexOf(in.substring(0, 1));
		xpos = Arrays.asList(xt).indexOf(in.substring(1, 2));
		ypos = Arrays.asList(yt).indexOf(in.substring(2, 3));
	}
	
	public int getX() { return xpos; }
	public int getY() { return ypos; }
	public int getZ() { return zpos; }
	
	public Position3D getOffset(int x, int y, int z) {
		return new Position3D(xpos+x, ypos+y, zpos+z);
	}
	
	public Position3D getOffset(Position3D offset) {
		return getOffset(offset.getX(), offset.getY(), offset.getZ());
	}
	
	@Override
	public String toString() {
		String x = xt[getX()];
		String y = yt[getY()];
		String z = zt[getZ()];
		return z+x+y;
		//return xpos+" "+ypos+" "+zpos;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o != null && o instanceof Position3D) {
			Position3D p = (Position3D)o;
			return getX()==p.getX()&&getY()==p.getY()&&getZ()==p.getZ();
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return xpos ^ ypos ^ zpos;
	}
}
