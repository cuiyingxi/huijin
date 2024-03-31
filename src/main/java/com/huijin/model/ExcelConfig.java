package com.huijin.model;

public class ExcelConfig {
    private String sheetName; // sheet名称
    private int titleRow; // 标题在第几行
    private int analysisCol; // 一共解析多少列

    public ExcelConfig(String sheetName, int titleRow, int analysisCol) {
        this.sheetName = sheetName;
        this.titleRow = titleRow;
        this.analysisCol = analysisCol;
    }

    public ExcelConfig() {
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public int getTitleRow() {
        return titleRow;
    }

    public void setTitleRow(int titleRow) {
        this.titleRow = titleRow;
    }

    public int getAnalysisCol() {
        return analysisCol;
    }

    public void setAnalysisCol(int analysisCol) {
        this.analysisCol = analysisCol;
    }

    @Override
    public String toString() {
        return "ExcelConfig{" +
                "sheetName='" + sheetName + '\'' +
                ", titleRow=" + titleRow +
                ", analysisCol=" + analysisCol +
                '}';
    }
}
