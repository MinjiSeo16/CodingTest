import java.io.*;
import java.util.*;

public class Main {
	public static class Player implements Comparable<Player>{
		int level;
		String name;

		public Player(int level, String name) {
			this.level = level;
			this.name = name;
		}

		@Override
		public int compareTo(Player p) {
			return this.name.compareTo(p.name);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<List<Player>> rooms = new ArrayList<>();

		for(int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			int level = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			Player player = new Player(level, name);

			boolean joined = false;
			for(List<Player> room : rooms) {
				int roomLevel = room.get(0).level;
				if(room.size() < m && level >= roomLevel - 10 && level <= roomLevel + 10) {
					room.add(player);
					joined = true;
					break;
				}
			}

			if(!joined) {
				List<Player> newRoom = new ArrayList<>();
				newRoom.add(player);
				rooms.add(newRoom);
			}
		}

		for(List<Player> room : rooms) {
			if(room.size() == m) {
				System.out.println("Started!");
			} else {
				System.out.println("Waiting!");
			}
			Collections.sort(room);
			for(Player player : room) {
				System.out.println(player.level + " " + player.name);
			}
		}
	}
}