package main;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Multiset;
import com.google.common.base.Splitter;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;

public class Program {
	public static void main(String[] args) {
		String text = "Some text qwerty, Hello World! Java Guava text text text XD 0_0 0_0 0_0 0_0 Java int Java b b b b b b b b b b b double Java int ytrewq JRE System Library main Maven Dependencies bin src src binary int bool double float qwerty main main a Guava a Guava a Guava a Guava a Guava a a a XD";
		Multiset<String> mset = HashMultiset.create();
		List<String> textSplit = Lists
				.newArrayList(Splitter.onPattern("\\W+").omitEmptyStrings().split(text));
		mset.addAll(textSplit);

		printHistagram(mset);
	}
	
	public static void printHistagram(Multiset<String> mset) {
		System.out.println("╔═════════════════════════  Count words with Multiset  ═════════════════════════╗");
		System.out.println("║                                   Histagram                                   ║");
		System.out.println("╠═══════════════════════════════════════════════════════════════════════════════╣");
		System.out.println(String.format("║%-8s", "Count") + String.format("%-15s", "Word") + String.format("%57s", "║"));
		System.out.println("╠───────────────────────────────────────────────────────────────────────────────╣");

		Set<String> set = mset.elementSet();
		
		for (String s : set) {
			StringBuilder sBuilder = new StringBuilder(100);

			sBuilder.append(String.format("║%-8s", mset.count(s)));
			sBuilder.append(String.format("%-15s", s));

			for (int i = 0; i < mset.count(s); i++) {
				sBuilder.append("██");
			}
			
			sBuilder.append(String.format("%" + (81 - sBuilder.length()) + "s", "║"));
			System.out.println(sBuilder);
		}
		
		System.out.println("╚═════════════════════════  Count words with Multiset  ═════════════════════════╝");
	}
}
