package nguyenleminhkhanh.QuanLyNhanSu.controller;

import nguyenleminhkhanh.QuanLyNhanSu.entity.NhanVien;
import nguyenleminhkhanh.QuanLyNhanSu.service.NhanVienService;
import nguyenleminhkhanh.QuanLyNhanSu.service.PhongBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;


@RequestMapping("/")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private PhongBanService phongBanService;
    @GetMapping
    public String showAll(Model model) {

        model.addAttribute("listnhanvien", nhanVienService.getAllNhanViens());
        model.addAttribute("title", "List");
        return "nhanvien/list";
    }

    @GetMapping("/add")
    public String addBookForm(Model model) {

        model.addAttribute("nhanvien", new NhanVien());
        model.addAttribute("phongBans", phongBanService.getAllPhongBan());
        return "nhanvien/add";
    }


    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("nhanvien") NhanVien nhanVien, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("nhanvien", phongBanService.getAllPhongBan());
            return "nhanvien/add";
        }
        nhanVienService.addNhanVien(nhanVien);
        return "redirect:/";
    }


    @GetMapping("/edit/{id}")
    public String editNhanVienForm(@PathVariable("id") int id, Model model){
        NhanVien editNhanVien = nhanVienService.getNhanVienById(id);
        if(editNhanVien != null){
            model.addAttribute("book", editNhanVien);
            model.addAttribute("categories", phongBanService.getAllPhongBan());
            return "nhanvien/edit";
        }else {
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editBook(@Valid @ModelAttribute("book")NhanVien updateNhanVien, BindingResult bindingResult, Model model ){
        if (bindingResult.hasErrors()){
            model.addAttribute("categories", phongBanService.getAllPhongBan());
            return "nhanvien/edit";
        }
        nhanVienService.getAllNhanViens().stream()
                .filter(book -> book.getId() == updateNhanVien.getId())
                .findFirst()
                .ifPresent(book -> {
                    nhanVienService.updateNhanVien(updateNhanVien);
                });
        return "redirect:/";
    }
    @PostMapping("/delete/{id}")
    public String deleteBookForm(@PathVariable("id") int id){
        nhanVienService.deleteNhanVien(id);
        return "redirect:/";
    }

    @GetMapping ("/delete/{id}")
    public String deleteBook (@PathVariable ("id") int id)  {
        nhanVienService.deleteNhanVien(id);
        return "redirect:/";
    }
}