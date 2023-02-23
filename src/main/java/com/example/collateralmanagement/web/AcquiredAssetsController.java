package com.example.collateralmanagement.web;

import com.example.collateralmanagement.models.dtos.asset.AddAcquiredAssetDTO;
import com.example.collateralmanagement.models.dtos.asset.DisplayAssetDTO;
import com.example.collateralmanagement.services.AcquiredAssetService;
import com.example.collateralmanagement.services.AssetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/acquiredAssets")
public class AcquiredAssetsController {

    private final AcquiredAssetService acquiredAssetService;

    private final AssetService assetService;

    @Autowired
    public AcquiredAssetsController(AcquiredAssetService acquiredAssetService, AssetService assetService) {
        this.acquiredAssetService = acquiredAssetService;
        this.assetService = assetService;
    }

    @ModelAttribute("addAcquiredAssetDTO")
    public AddAcquiredAssetDTO init (Model model) {
        AddAcquiredAssetDTO addAcquiredAssetDTO = new AddAcquiredAssetDTO();
        model.addAttribute("addAcquiredAssetDTO",addAcquiredAssetDTO);
        return addAcquiredAssetDTO;
    }

    @GetMapping("chooseAsset/{id}")
    public String chooseAsset(@PathVariable Long id){
        //this.assetService.chooseAsset(id);

        return "redirect:/acquiredAssets/add";

    }

    @GetMapping("/add")
    public String displayAddAcquiredAsset(Model model){

//        List<DisplayAssetDTO> assetsOfClient =this.assetService.findAllAssetsOfClient(clientBULSTATorEGN );
//        model.addAttribute("assetsOfClient", assetsOfClient);

        return "addAcquiredAsset";
    }
    @PostMapping("/save")
    public String saveAcquiredAsset(@Valid AddAcquiredAssetDTO addAcquiredAssetDTO, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addAcquiredAssetDTO", addAcquiredAssetDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addAcquiredAssetDTO", bindingResult);
            return "redirect:/acquiredAssets/add";
        }
        this.acquiredAssetService.addAcquiredAsset(addAcquiredAssetDTO);
        return "redirect:/acquiredAssets";
    }

}
