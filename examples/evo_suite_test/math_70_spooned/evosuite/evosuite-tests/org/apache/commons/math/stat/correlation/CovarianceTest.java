package org.apache.commons.math.stat.correlation;


public class CovarianceTest extends junit.framework.TestCase {
	protected final double[] longleyData = new double[]{ 60323 , 83.0 , 234289 , 2356 , 1590 , 107608 , 1947 , 61122 , 88.5 , 259426 , 2325 , 1456 , 108632 , 1948 , 60171 , 88.2 , 258054 , 3682 , 1616 , 109773 , 1949 , 61187 , 89.5 , 284599 , 3351 , 1650 , 110929 , 1950 , 63221 , 96.2 , 328975 , 2099 , 3099 , 112075 , 1951 , 63639 , 98.1 , 346999 , 1932 , 3594 , 113270 , 1952 , 64989 , 99.0 , 365385 , 1870 , 3547 , 115094 , 1953 , 63761 , 100.0 , 363112 , 3578 , 3350 , 116219 , 1954 , 66019 , 101.2 , 397469 , 2904 , 3048 , 117388 , 1955 , 67857 , 104.6 , 419180 , 2822 , 2857 , 118734 , 1956 , 68169 , 108.4 , 442769 , 2936 , 2798 , 120445 , 1957 , 66513 , 110.8 , 444546 , 4681 , 2637 , 121950 , 1958 , 68655 , 112.6 , 482704 , 3813 , 2552 , 123366 , 1959 , 69564 , 114.2 , 502601 , 3931 , 2514 , 125368 , 1960 , 69331 , 115.7 , 518173 , 4806 , 2572 , 127852 , 1961 , 70551 , 116.9 , 554894 , 4007 , 2827 , 130081 , 1962 };

	protected final double[] swissData = new double[]{ 80.2 , 17.0 , 15 , 12 , 9.96 , 83.1 , 45.1 , 6 , 9 , 84.84 , 92.5 , 39.7 , 5 , 5 , 93.4 , 85.8 , 36.5 , 12 , 7 , 33.77 , 76.9 , 43.5 , 17 , 15 , 5.16 , 76.1 , 35.3 , 9 , 7 , 90.57 , 83.8 , 70.2 , 16 , 7 , 92.85 , 92.4 , 67.8 , 14 , 8 , 97.16 , 82.4 , 53.3 , 12 , 7 , 97.67 , 82.9 , 45.2 , 16 , 13 , 91.38 , 87.1 , 64.5 , 14 , 6 , 98.61 , 64.1 , 62.0 , 21 , 12 , 8.52 , 66.9 , 67.5 , 14 , 7 , 2.27 , 68.9 , 60.7 , 19 , 12 , 4.43 , 61.7 , 69.3 , 22 , 5 , 2.82 , 68.3 , 72.6 , 18 , 2 , 24.2 , 71.7 , 34.0 , 17 , 8 , 3.3 , 55.7 , 19.4 , 26 , 28 , 12.11 , 54.3 , 15.2 , 31 , 20 , 2.15 , 65.1 , 73.0 , 19 , 9 , 2.84 , 65.5 , 59.8 , 22 , 10 , 5.23 , 65.0 , 55.1 , 14 , 3 , 4.52 , 56.6 , 50.9 , 22 , 12 , 15.14 , 57.4 , 54.1 , 20 , 6 , 4.2 , 72.5 , 71.2 , 12 , 1 , 2.4 , 74.2 , 58.1 , 14 , 8 , 5.23 , 72.0 , 63.5 , 6 , 3 , 2.56 , 60.5 , 60.8 , 16 , 10 , 7.72 , 58.3 , 26.8 , 25 , 19 , 18.46 , 65.4 , 49.5 , 15 , 8 , 6.1 , 75.5 , 85.9 , 3 , 2 , 99.71 , 69.3 , 84.9 , 7 , 6 , 99.68 , 77.3 , 89.7 , 5 , 2 , 100.0 , 70.5 , 78.2 , 12 , 6 , 98.96 , 79.4 , 64.9 , 7 , 3 , 98.22 , 65.0 , 75.9 , 9 , 9 , 99.06 , 92.2 , 84.6 , 3 , 3 , 99.46 , 79.3 , 63.1 , 13 , 13 , 96.83 , 70.4 , 38.4 , 26 , 12 , 5.62 , 65.7 , 7.7 , 29 , 11 , 13.79 , 72.7 , 16.7 , 22 , 13 , 11.22 , 64.4 , 17.6 , 35 , 32 , 16.92 , 77.6 , 37.6 , 15 , 7 , 4.97 , 67.6 , 18.7 , 25 , 7 , 8.65 , 35.0 , 1.2 , 37 , 53 , 42.34 , 44.7 , 46.6 , 16 , 29 , 50.43 , 42.8 , 27.7 , 22 , 29 , 58.33 };

	public void testLongly() {
		org.apache.commons.math.linear.RealMatrix matrix = createRealMatrix(longleyData, 16, 7);
		org.apache.commons.math.linear.RealMatrix covarianceMatrix = new org.apache.commons.math.stat.correlation.Covariance(matrix).getCovarianceMatrix();
		double[] rData = new double[]{ 1.2333921733333332E7 , 36796.66 , 3.433302063333333E8 , 1649102.6666666667 , 1117681.0666666667 , 2.3461965733333334E7 , 16240.933333333332 , 36796.66 , 116.457625 , 1063604.115416667 , 6258.66625 , 3490.25375 , 73503.0 , 50.92333333333334 , 3.433302063333333E8 , 1063604.115416667 , 9.879353659329166E9 , 5.6124369854166664E7 , 3.0880428345833335E7 , 6.852409446E8 , 470977.9 , 1649102.6666666667 , 6258.66625 , 5.6124369854166664E7 , 873223.4291666667 , -115378.7625 , 4462741.533333333 , 2973.0333333333333 , 1117681.0666666667 , 3490.25375 , 3.0880428345833335E7 , -115378.7625 , 484304.0958333333 , 1764098.133333333 , 1382.4333333333334 , 2.3461965733333334E7 , 73503.0 , 6.852409446E8 , 4462741.533333333 , 1764098.1333333333 , 4.838734893333333E7 , 32917.4 , 16240.93333333333 , 50.92333333333334 , 470977.9 , 2973.033333333333 , 1382.433333333333 , 32917.4 , 22.66666666666667 };
		org.apache.commons.math.TestUtils.assertEquals("covariance matrix", createRealMatrix(rData, 7, 7), covarianceMatrix, 1.0E-8);
	}

	public void testSwissFertility() {
		org.apache.commons.math.linear.RealMatrix matrix = createRealMatrix(swissData, 47, 5);
		org.apache.commons.math.linear.RealMatrix covarianceMatrix = new org.apache.commons.math.stat.correlation.Covariance(matrix).getCovarianceMatrix();
		double[] rData = new double[]{ 156.0424976873265 , 100.1691489361702 , -64.36692876965772 , -79.7295097132285 , 241.5632030527289 , 100.16914893617025 , 515.7994172062905 , -124.39283071230344 , -139.6574005550416 , 379.9043755781684 , -64.3669287696577 , -124.3928307123034 , 63.64662349676226 , 53.5758556891767 , -190.5606105457909 , -79.7295097132285 , -139.6574005550416 , 53.57585568917669 , 92.4560592044403 , -61.698829787234 , 241.5632030527289 , 379.9043755781684 , -190.56061054579092 , -61.698829787234 , 1739.294537187789 };
		org.apache.commons.math.TestUtils.assertEquals("covariance matrix", createRealMatrix(rData, 5, 5), covarianceMatrix, 1.0E-12);
	}

	public void testConstant() {
		double[] noVariance = new double[]{ 1 , 1 , 1 , 1 };
		double[] values = new double[]{ 1 , 2 , 3 , 4 };
		junit.framework.Assert.assertEquals(0.0, new org.apache.commons.math.stat.correlation.Covariance().covariance(noVariance, values, true), java.lang.Double.MIN_VALUE);
		junit.framework.Assert.assertEquals(0.0, new org.apache.commons.math.stat.correlation.Covariance().covariance(noVariance, noVariance, true), java.lang.Double.MIN_VALUE);
	}

	public void testInsufficientData() {
		double[] one = new double[]{ 1 };
		double[] two = new double[]{ 2 };
		try {
			new org.apache.commons.math.stat.correlation.Covariance().covariance(one, two, false);
			junit.framework.Assert.fail("Expecting IllegalArgumentException");
		} catch (java.lang.IllegalArgumentException ex) {
		}
		org.apache.commons.math.linear.RealMatrix matrix = new org.apache.commons.math.linear.Array2DRowRealMatrix(new double[][]{ new double[]{ 0 } , new double[]{ 1 } });
		try {
			new org.apache.commons.math.stat.correlation.Covariance(matrix);
			junit.framework.Assert.fail("Expecting IllegalArgumentException");
		} catch (java.lang.IllegalArgumentException ex) {
		}
	}

	public void testConsistency() {
		final org.apache.commons.math.linear.RealMatrix matrix = createRealMatrix(swissData, 47, 5);
		final org.apache.commons.math.linear.RealMatrix covarianceMatrix = new org.apache.commons.math.stat.correlation.Covariance(matrix).getCovarianceMatrix();
		org.apache.commons.math.stat.descriptive.moment.Variance variance = new org.apache.commons.math.stat.descriptive.moment.Variance();
		for (int i = 0 ; i < 5 ; i++) {
			junit.framework.Assert.assertEquals(variance.evaluate(matrix.getColumn(i)), covarianceMatrix.getEntry(i, i), 1.0E-13);
		}
		junit.framework.Assert.assertEquals(covarianceMatrix.getEntry(2, 3), new org.apache.commons.math.stat.correlation.Covariance().covariance(matrix.getColumn(2), matrix.getColumn(3), true), 1.0E-13);
		junit.framework.Assert.assertEquals(covarianceMatrix.getEntry(2, 3), covarianceMatrix.getEntry(3, 2), java.lang.Double.MIN_VALUE);
		org.apache.commons.math.linear.RealMatrix repeatedColumns = new org.apache.commons.math.linear.Array2DRowRealMatrix(47 , 3);
		for (int i = 0 ; i < 3 ; i++) {
			repeatedColumns.setColumnMatrix(i, matrix.getColumnMatrix(0));
		}
		org.apache.commons.math.linear.RealMatrix repeatedCovarianceMatrix = new org.apache.commons.math.stat.correlation.Covariance(repeatedColumns).getCovarianceMatrix();
		double columnVariance = variance.evaluate(matrix.getColumn(0));
		for (int i = 0 ; i < 3 ; i++) {
			for (int j = 0 ; j < 3 ; j++) {
				junit.framework.Assert.assertEquals(columnVariance, repeatedCovarianceMatrix.getEntry(i, j), 1.0E-13);
			}
		}
		double[][] data = matrix.getData();
		org.apache.commons.math.TestUtils.assertEquals("Covariances", covarianceMatrix, new org.apache.commons.math.stat.correlation.Covariance().computeCovarianceMatrix(data), java.lang.Double.MIN_VALUE);
		org.apache.commons.math.TestUtils.assertEquals("Covariances", covarianceMatrix, new org.apache.commons.math.stat.correlation.Covariance().computeCovarianceMatrix(data, true), java.lang.Double.MIN_VALUE);
		double[] x = data[0];
		double[] y = data[1];
		junit.framework.Assert.assertEquals(new org.apache.commons.math.stat.correlation.Covariance().covariance(x, y), new org.apache.commons.math.stat.correlation.Covariance().covariance(x, y, true), java.lang.Double.MIN_VALUE);
	}

	protected org.apache.commons.math.linear.RealMatrix createRealMatrix(double[] data, int nRows, int nCols) {
		double[][] matrixData = new double[nRows][nCols];
		int ptr = 0;
		for (int i = 0 ; i < nRows ; i++) {
			java.lang.System.arraycopy(data, ptr, matrixData[i], 0, nCols);
			ptr += nCols;
		}
		return new org.apache.commons.math.linear.Array2DRowRealMatrix(matrixData);
	}
}
