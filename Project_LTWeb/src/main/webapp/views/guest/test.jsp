<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<html>
<button class="custom-btn btn-1">Button 1</button>

  <button class="custom-btn btn-2">Button 2</button>

  <button class="custom-btn btn-3"><span>Button 3</span></button>

  <button class="custom-btn btn-4"><span>Button 4</span></button>

  <button class="custom-btn btn-5"><span>Button 5</span></button>

  <button class="custom-btn btn-6"><span>Button 6</span></button>

  <button class="custom-btn btn-7"><span>Button 7</span></button>

  <button class="custom-btn btn-8"><span>Button 8</span></button>

  <button class="custom-btn btn-9">Button 9</button>

  <button class="custom-btn btn-10">Button 10</button>

  <button class="custom-btn btn-11">Button 11<div class="dot"></div></button>

  <button class="custom-btn btn-12"><span>Click!</span><span>Button 12</span></button>

  <button class="custom-btn btn-13">Button 13</button>

  <button class="custom-btn btn-14">Button 14</button>

  <button class="custom-btn btn-15">Button 15</button>

  <button class="custom-btn btn-16">Button 16</button>
</html>

<style>
/*CSS*/

/*đoạn css định hình cho button*/

.custom-btn {

  width: 130px;

  height: 40px;

  color: #fff;

  border-radius: 5px;

  padding: 10px 25px;

  font-family: 'Lato', sans-serif;

  font-weight: 500;

  background: transparent;

  cursor: pointer;

  transition: all 0.3s ease;

  position: relative;

  display: inline-block;

   box-shadow:inset 2px 2px 2px 0px rgba(255,255,255,.5),

   7px 7px 20px 0px rgba(0,0,0,.1),

   4px 4px 5px 0px rgba(0,0,0,.1);

  outline: none;

}

 

/* Hiệu ứng 1 */

.btn-1 {

  background: rgb(6,14,131);

  background: linear-gradient(0deg, rgba(6,14,131,1) 0%, rgba(12,25,180,1) 100%);

  border: none;

}

.btn-1:hover {

   background: rgb(0,3,255);

background: linear-gradient(0deg, rgba(0,3,255,1) 0%, rgba(2,126,251,1) 100%);

}

 

/*Hiệu ứng  2 */

.btn-2 {

  background: rgb(96,9,240);

  background: linear-gradient(0deg, rgba(96,9,240,1) 0%, rgba(129,5,240,1) 100%);

  border: none;
}

.btn-2:before {

  height: 0%;

  width: 2px;

}

.btn-2:hover {

  box-shadow:  4px 4px 6px 0 rgba(255,255,255,.5),

              -4px -4px 6px 0 rgba(116, 125, 136, .5),

    inset -4px -4px 6px 0 rgba(255,255,255,.2),

    inset 4px 4px 6px 0 rgba(0, 0, 0, .4);

}

 

 

/*Hiệu ứng  3 */

.btn-3 {

  background: rgb(0,172,238);

background: linear-gradient(0deg, rgba(0,172,238,1) 0%, rgba(2,126,251,1) 100%);

  width: 130px;

  height: 40px;

  line-height: 42px;

  padding: 0;

  border: none;

 

}

.btn-3 span {

  position: relative;

  display: block;

  width: 100%;

  height: 100%;

}

.btn-3:before,

.btn-3:after {

  position: absolute;

  content: "";

  right: 0;

  top: 0;

   background: rgba(2,126,251,1);

  transition: all 0.3s ease;

}

.btn-3:before {

  height: 0%;

  width: 2px;

}

.btn-3:after {

  width: 0%;

  height: 2px;

}

.btn-3:hover{

   background: transparent;

  box-shadow: none;

}

.btn-3:hover:before {

  height: 100%;

}

.btn-3:hover:after {

  width: 100%;

}

.btn-3 span:hover{

   color: rgba(2,126,251,1);

}

.btn-3 span:before,

.btn-3 span:after {

  position: absolute;

  content: "";

  left: 0;

  bottom: 0;

   background: rgba(2,126,251,1);

  transition: all 0.3s ease;

}

.btn-3 span:before {

  width: 2px;

  height: 0%;

}

.btn-3 span:after {

  width: 0%;

  height: 2px;

}

.btn-3 span:hover:before {

  height: 100%;

}

.btn-3 span:hover:after {

  width: 100%;

}

 

/*Hiệu ứng  4 */

.btn-4 {

  background-color: #4dccc6;

background-image: linear-gradient(315deg, #4dccc6 0%, #96e4df 74%);

  line-height: 42px;

  padding: 0;

  border: none;

}

.btn-4:hover{

  background-color: #89d8d3;

background-image: linear-gradient(315deg, #89d8d3 0%, #03c8a8 74%);

}

.btn-4 span {

  position: relative;

  display: block;

  width: 100%;

  height: 100%;

}

.btn-4:before,

.btn-4:after {

  position: absolute;

  content: "";

  right: 0;

  top: 0;

   box-shadow:  4px 4px 6px 0 rgba(255,255,255,.9),

              -4px -4px 6px 0 rgba(116, 125, 136, .2),

    inset -4px -4px 6px 0 rgba(255,255,255,.9),

    inset 4px 4px 6px 0 rgba(116, 125, 136, .3);

  transition: all 0.3s ease;

}

.btn-4:before {

  height: 0%;

  width: .1px;

}

.btn-4:after {

  width: 0%;

  height: .1px;

}

.btn-4:hover:before {

  height: 100%;

}

.btn-4:hover:after {

  width: 100%;

}

.btn-4 span:before,

.btn-4 span:after {

  position: absolute;

  content: "";

  left: 0;

  bottom: 0;

  box-shadow:  4px 4px 6px 0 rgba(255,255,255,.9),

              -4px -4px 6px 0 rgba(116, 125, 136, .2),

    inset -4px -4px 6px 0 rgba(255,255,255,.9),

    inset 4px 4px 6px 0 rgba(116, 125, 136, .3);

  transition: all 0.3s ease;

}

.btn-4 span:before {

  width: .1px;

  height: 0%;

}

.btn-4 span:after {

  width: 0%;

  height: .1px;

}

.btn-4 span:hover:before {

  height: 100%;

}

.btn-4 span:hover:after {

  width: 100%;

}

 

/*Hiệu ứng  5 */

.btn-5 {

  width: 130px;

  height: 40px;

  line-height: 42px;

  padding: 0;

  border: none;

  background: rgb(255,27,0);

background: linear-gradient(0deg, rgba(255,27,0,1) 0%, rgba(251,75,2,1) 100%);

}

.btn-5:hover {

  color: #f0094a;

  background: transparent;

   box-shadow:none;

}

.btn-5:before,

.btn-5:after{

  content:'';

  position:absolute;

  top:0;

  right:0;

  height:2px;

  width:0;

  background: #f0094a;

  box-shadow:

   -1px -1px 5px 0px #fff,

   7px 7px 20px 0px #0003,

   4px 4px 5px 0px #0002;

  transition:400ms ease all;

}

.btn-5:after{

  right:inherit;

  top:inherit;

  left:0;

  bottom:0;

}

.btn-5:hover:before,

.btn-5:hover:after{

  width:100%;

  transition:800ms ease all;

}

 

 

/*Hiệu ứng  6 */

.btn-6 {

  background: rgb(247,150,192);

background: radial-gradient(circle, rgba(247,150,192,1) 0%, rgba(118,174,241,1) 100%);

  line-height: 42px;

  padding: 0;

  border: none;

}

.btn-6 span {

  position: relative;

  display: block;

  width: 100%;

  height: 100%;

}

.btn-6:before,

.btn-6:after {

  position: absolute;

  content: "";

  height: 0%;

  width: 1px;

 box-shadow:

   -1px -1px 20px 0px rgba(255,255,255,1),

   -4px -4px 5px 0px rgba(255,255,255,1),

   7px 7px 20px 0px rgba(0,0,0,.4),

   4px 4px 5px 0px rgba(0,0,0,.3);

}

.btn-6:before {

  right: 0;

  top: 0;

  transition: all 500ms ease;

}

.btn-6:after {

  left: 0;

  bottom: 0;

  transition: all 500ms ease;

}

.btn-6:hover{

  background: transparent;

  color: #76aef1;

  box-shadow: none;

}

.btn-6:hover:before {

  transition: all 500ms ease;

  height: 100%;

}

.btn-6:hover:after {

  transition: all 500ms ease;

  height: 100%;

}

.btn-6 span:before,

.btn-6 span:after {

  position: absolute;

  content: "";

  box-shadow:

   -1px -1px 20px 0px rgba(255,255,255,1),

   -4px -4px 5px 0px rgba(255,255,255,1),

   7px 7px 20px 0px rgba(0,0,0,.4),

   4px 4px 5px 0px rgba(0,0,0,.3);

}

.btn-6 span:before {

  left: 0;

  top: 0;

  width: 0%;

  height: .5px;

  transition: all 500ms ease;

}

.btn-6 span:after {

  right: 0;

  bottom: 0;

  width: 0%;

  height: .5px;

  transition: all 500ms ease;

}

.btn-6 span:hover:before {

  width: 100%;

}

.btn-6 span:hover:after {

  width: 100%;

}

 

/*Hiệu ứng  7 */

.btn-7 {

background: linear-gradient(0deg, rgba(255,151,0,1) 0%, rgba(251,75,2,1) 100%);

  line-height: 42px;

  padding: 0;

  border: none;

}

.btn-7 span {

  position: relative;

  display: block;

  width: 100%;

  height: 100%;

}

.btn-7:before,

.btn-7:after {

  position: absolute;

  content: "";

  right: 0;

  bottom: 0;

  background: rgba(251,75,2,1);

  box-shadow:

   -7px -7px 20px 0px rgba(255,255,255,.9),

   -4px -4px 5px 0px rgba(255,255,255,.9),

   7px 7px 20px 0px rgba(0,0,0,.2),

   4px 4px 5px 0px rgba(0,0,0,.3);

  transition: all 0.3s ease;

}

.btn-7:before{

   height: 0%;

   width: 2px;

}

.btn-7:after {

  width: 0%;

  height: 2px;

}

.btn-7:hover{

  color: rgba(251,75,2,1);

  background: transparent;

}

.btn-7:hover:before {

  height: 100%;

}

.btn-7:hover:after {

  width: 100%;

}

.btn-7 span:before,

.btn-7 span:after {

  position: absolute;

  content: "";

  left: 0;

  top: 0;

  background: rgba(251,75,2,1);

  box-shadow:

   -7px -7px 20px 0px rgba(255,255,255,.9),

   -4px -4px 5px 0px rgba(255,255,255,.9),

   7px 7px 20px 0px rgba(0,0,0,.2),

   4px 4px 5px 0px rgba(0,0,0,.3);

  transition: all 0.3s ease;

}

.btn-7 span:before {

  width: 2px;

  height: 0%;

}

.btn-7 span:after {

  height: 2px;

  width: 0%;

}

.btn-7 span:hover:before {

  height: 100%;

}

.btn-7 span:hover:after {

  width: 100%;

}

 

/*Hiệu ứng  8 */

.btn-8 {

  background-color: #f0ecfc;

background-image: linear-gradient(315deg, #f0ecfc 0%, #c797eb 74%);

  line-height: 42px;

  padding: 0;

  border: none;

}

.btn-8 span {

  position: relative;

  display: block;

  width: 100%;

  height: 100%;

}

.btn-8:before,

.btn-8:after {

  position: absolute;

  content: "";

  right: 0;

  bottom: 0;

  background: #c797eb;

  /*box-shadow:  4px 4px 6px 0 rgba(255,255,255,.5),

              -4px -4px 6px 0 rgba(116, 125, 136, .2),

    inset -4px -4px 6px 0 rgba(255,255,255,.5),

    inset 4px 4px 6px 0 rgba(116, 125, 136, .3);*/

  transition: all 0.3s ease;

}

.btn-8:before{

   height: 0%;

   width: 2px;

}

.btn-8:after {

  width: 0%;

  height: 2px;

}

.btn-8:hover:before {

  height: 100%;

}

.btn-8:hover:after {

  width: 100%;

}

.btn-8:hover{

  background: transparent;

}

.btn-8 span:hover{

  color: #c797eb;

}

.btn-8 span:before,

.btn-8 span:after {

  position: absolute;

  content: "";

  left: 0;

  top: 0;

  background: #c797eb;

  /*box-shadow:  4px 4px 6px 0 rgba(255,255,255,.5),

              -4px -4px 6px 0 rgba(116, 125, 136, .2),

    inset -4px -4px 6px 0 rgba(255,255,255,.5),

    inset 4px 4px 6px 0 rgba(116, 125, 136, .3);*/

  transition: all 0.3s ease;

}

.btn-8 span:before {

  width: 2px;

  height: 0%;

}

.btn-8 span:after {

  height: 2px;

  width: 0%;

}

.btn-8 span:hover:before {

  height: 100%;

}

.btn-8 span:hover:after {

  width: 100%;

}

 
</style>