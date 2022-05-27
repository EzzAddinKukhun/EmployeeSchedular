/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

import javafx.scene.control.CheckBox;

/**
 *
 * @author lenovo
 */
public class Leaves {
    
    String id; 
    String person_id; 
    String date; 
    String start_time; 
    String end_time; 
    String type; 
    String duration ; 
    CheckBox checkbox; 

    public Leaves(String id, String person_id, String date, String start_time, String end_time, String type, String duration) {
        this.id = id;
        this.person_id = person_id;
        this.date = date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.type = type;
        this.duration = duration;
        this.checkbox = new CheckBox (); 
    }
    
    public Leaves(String id, String date, String start_time, String end_time, String type, String duration) {
        this.id = id;
        this.date = date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.type = type;
        this.duration = duration;
        this.checkbox = new CheckBox (); 
    }

  

    public String getId() {
        return id;
    }

    public String getPerson_id() {
        return person_id;
    }

    public String getDate() {
        return date;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public String getType() {
        return type;
    }

    public String getDuration() {
        return duration;
    }

    public CheckBox getCheckbox() {
        return checkbox;
    }
    
    
    
    
    
    
}
