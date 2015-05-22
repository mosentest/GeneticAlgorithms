package com.ga.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * GeneticAlgorithms 给定参数，测试遗传算法
 * 
 * @author 邓锴
 *
 */
public class GeneticAlgorithms {
	public static double crossoverRate;// 交叉概率
	public static double mutateRate;// 变异概率
	public static int maxGeneration;// 进化代数
	public static int populationSize;// 群体大小

	static {
		maxGeneration = 10;
		populationSize = 30;
		crossoverRate = 1;
		mutateRate = 0.001;
	}

	public static void main(String[] args) throws IOException {

		FileWriter fw = new FileWriter("result.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);

		Population pop = new Population(populationSize);
		pop.initPopulation();

		pw.println("初始测试用例数目为" + populationSize + ":\n" + pop);
		while (!pop.isEvolutionDone()) {
			pop.evolve();
//			pw.print("第" + pop.getGeneration() + "代Best:" + pop.bestIndividual);
//			pw.print("第" + pop.getGeneration() + "代current:" + pop.currentBest);
//			pw.print("第" + pop.getGeneration() + "代worst:" + pop.worstIndividual);
//			pw.println("第" + pop.getGeneration() + "代群体:\n" + pop);
//			double[] calRelativeFitness = pop.calRelativeFitness();
//			for (int i = 0; i < calRelativeFitness.length; i++) {
//				pw.println("选择概率:" + calRelativeFitness[i]);
//			}
//			pw.println();
		}
//		pw.print("第" + pop.getGeneration() + "代Best:" + pop.bestIndividual);
//		pw.print("第" + pop.getGeneration() + "代current:" + pop.currentBest);
//		pw.print("第" + pop.getGeneration() + "代worst:" + pop.worstIndividual);
		pw.println("第" + pop.getGeneration() + "代群体:\n"+pop);
		Individual[] pop2 = pop.getPop();
		List<Individual> list = new ArrayList<Individual>();
		Chromosome chrom = pop2[0].getChrom();
		String max = chrom.getChromosome().toString();
		int index = 0;
		for (int i = 0; i < pop2.length; i++) {
			list.add(pop2[i]);
			String temp = pop2[i].getChrom().getChromosome().toString();
			if (temp.compareTo(max) > 0){
				index=i;
				max = temp;
			}
		}
		HashSet h = new HashSet(list);
		list.clear();
		list.addAll(h);
		Iterator<Individual> iterator = list.iterator();
		pw.println("约简后数目为"+list.size()+":");
		while(iterator.hasNext()){
			pw.print(iterator.next());
		}
		pw.println("其中最高是：");
		pw.println(pop2[index]);
		
//		double[] calRelativeFitness = pop.calRelativeFitness();
//		for (int i = 0; i < calRelativeFitness.length; i++) {
//			pw.println("选择概率:" + calRelativeFitness[i]);
//		}
		pw.println();
		pw.close();
	}
}
