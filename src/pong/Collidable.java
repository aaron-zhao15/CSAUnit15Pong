/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

/**
 *
 * @author XingLu
 */
public interface Collidable
{
    boolean didCollideLeft(Object obj);
    boolean didCollideRight(Object obj);
//    boolean didCollideTop(Object obj);
//    boolean didCollideBottom(Object obj);
}
