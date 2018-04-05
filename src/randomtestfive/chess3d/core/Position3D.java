package randomtestfive.chess3d.core;

public class Position3D {
	private final int xpos, ypos, zpos;
	
	public Position3D(int x, int y, int z) {
		xpos = x;
		ypos = y;
		zpos = z;
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
		String x = (new String[]{"a","b","c","d","e"})[getX()];
		String y = (new String[]{"1","2","3","4","5"})[getY()];
		String z = (new String[]{"A","B","C","D","E"})[getZ()];
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
}
