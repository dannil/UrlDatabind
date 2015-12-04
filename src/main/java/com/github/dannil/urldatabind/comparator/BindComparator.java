package com.github.dannil.urldatabind.comparator;

import java.util.Comparator;

import com.github.dannil.urldatabind.model.bind.Bind;

public class BindComparator implements Comparator<Bind<?>> {

	@Override
	public int compare(Bind<?> b1, Bind<?> b2) {
		// NOT FINISHED
		
		String path1 = b1.getPath();
		String path2 = b2.getPath();
		
		int minLength = Math.min(path1.length(), path2.length());
		
		for (int i = 0; i < minLength; i++) {
			int c1 = (char)path1.charAt(i);
			int c2 = (char)path2.charAt(i);
			if (c1 > c2) {
				return 1;
			}
			if (c1 < c2) {
				return -1;
			}
		}
		return 0;
	}

}
