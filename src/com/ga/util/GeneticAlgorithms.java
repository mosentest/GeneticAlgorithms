package com.ga.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
		maxGeneration = 3;
		populationSize = 4;
		crossoverRate = 0.6;
		mutateRate = 0.001;
	}

	public static void main(String[] args) throws IOException {

		FileWriter fw = new FileWriter("result.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);

		Population pop = new Population(populationSize);
		pop.initPopulation();

		pw.println("初始数量:" + populationSize + "的种群:\n" + pop);
		while (!pop.isEvolutionDone()) {
			pop.evolve();
			pw.print("第" + pop.getGeneration() + "代Best:" + pop.bestIndividual);
			pw.print("第" + pop.getGeneration() + "代current:" + pop.currentBest);
			pw.print("第" + pop.getGeneration() + "代worst:" + pop.worstIndividual);
			pw.println("第" + pop.getGeneration() + "代群体:\n" + pop);
			double[] calRelativeFitness = pop.calRelativeFitness();
			for (int i = 0; i < calRelativeFitness.length; i++) {
				pw.println("选择概率:" + calRelativeFitness[i]);
			}
			pw.println();
		}
		pw.close();
	}
}
