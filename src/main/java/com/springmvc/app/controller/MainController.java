package com.springmvc.app.controller;

import com.springmvc.app.domain.Item;
import com.springmvc.app.domain.Orders;
import com.springmvc.app.domain.User;
import com.springmvc.app.services.ItemServce;
import com.springmvc.app.services.OrdersService;
import com.springmvc.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private UserService userService;
    @Autowired
    private ItemServce itemServce;
    @Autowired
    private OrdersService ordersService;

    public MainController(UserService userService, ItemServce itemServce, OrdersService ordersService) {
        this.userService = userService;
        this.itemServce = itemServce;
        this.ordersService = ordersService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewRecords(Model model) {
        model.addAttribute("viewUsers", userService.getAllUsersRecords());
        model.addAttribute("viewItems", itemServce.getAllItemsRecords());
        model.addAttribute("viewOrders", ordersService.getAllOrdersRecords());
        return "ordershop";
    }


    @GetMapping("/showNewOrderForm")
    public String showNewOrderForm(Model model) {

        Orders order = new Orders();
        model.addAttribute("order", order);
        return "neworder";
    }


    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "newuser";

    }

    @GetMapping("/showNewItemForm")
    public String showNewItemForm(Model model) {
        Item item = new Item();
        model.addAttribute("item", item);
        return "newitem";
    }


    @PostMapping("/saveOrder")
    public String saveNewOrderRecords(@ModelAttribute("order") Orders order) {
        ordersService.saveOrderIntoDB(order);
        return "redirect:/";
    }

    @PostMapping("/saveUser")
    public String saveNewUserRecords(@ModelAttribute("user") User user) {
        userService.saveUserIntoDB(user);
        return "redirect:/";
    }

    @PostMapping("/saveItem")
    public String saveNewItemRecords(@ModelAttribute("item") Item item) {
        itemServce.saveItemIntoDB(item);
        return "redirect:/";
    }

    @GetMapping("/updateOrder/{id}")
    public String updateOrderDetail(@PathVariable(value = "id") Long id, Model model) {
        Orders order = ordersService.getOrderById(id);
        model.addAttribute("order", order);
        return "editorder";
    }

    @GetMapping("/deleteItem/{id}")
    public String deleteitem(@PathVariable(value = "id") Long id) {
        this.itemServce.deleteItem(id);
        return "redirect:/";
    }

    @GetMapping("/updateItem/{id}")
    public String updateItemDetail(@PathVariable(value = "id") Long id, Model model) {
        Item item = itemServce.getItemById(id);
        model.addAttribute("item", item);
        return "edititem";
    }

    @GetMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable(value = "id") Long id) {
        this.ordersService.deleteOrder(id);
        return "redirect:/";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUserDetail(@PathVariable(value = "id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edituser";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") Long id) {
        this.userService.deleteUser(id);
        return "redirect:/";
    }
}
