package com.extension.exercise;

public class Computer {
    private String CPU;
    private int Memory;
    private int Disk;

    public Computer(String CPU, int memory, int disk) {
        this.CPU = CPU;
        this.Memory = memory;
        this.Disk = disk;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public void setDisk(int disk) {
        Disk = disk;
    }

    public void setMemory(int memory) {
        Memory = memory;
    }

    public String getCPU() {
        return CPU;
    }

    public int getMemory() {
        return Memory;
    }

    public int getDisk() {
        return Disk;
    }

    public String getDetails() {
        return "CPU: " + CPU + " Memory: " + Memory + " Disk: " + Disk;
    }
}
