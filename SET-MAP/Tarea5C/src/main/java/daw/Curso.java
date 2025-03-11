/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

/**
 *
 * @author carlos
 */
public class Curso {
    private int id;
    private String gradeName;
    private int hours; 

    public Curso() {
    }

    public Curso(int id, String gradeName, int hours) {
        this.id = id;
        this.gradeName = gradeName;
        this.hours = hours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Curso{" + "id=" + id + ", gradeName=" + gradeName + ", hours=" + hours + '}';
    }


    
}
