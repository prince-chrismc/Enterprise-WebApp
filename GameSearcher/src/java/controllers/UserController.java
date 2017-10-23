/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

/**
 *
 * @author cmcarthur
 */
@Controller
public class UserController
{
   @RequestMapping(value = "/user", method = RequestMethod.GET)
   public ModelAndView user()
   {
      return new ModelAndView("user", "command", new User());
   }
   @RequestMapping(value = "/addUser", method = RequestMethod.POST)
   public String addUser(@ModelAttribute("SpringWeb")User user, 
                         ModelMap model)
   {
      model.addAttribute("m_FirstName", user.getFirstName());
      model.addAttribute("m_LastName", user.getLastName());
      model.addAttribute("m_Email", user.getEmail());
      
      return "NewUserResult.html";
   }
}
