package com.devlog.piano.gallery.contrller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GalleryController {

    @GetMapping("/gallery")
    public String galleryPage() {
        return "gallery/gallery";
    }
}
