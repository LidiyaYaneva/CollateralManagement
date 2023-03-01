package com.example.collateralmanagement.web.asset;

import com.example.collateralmanagement.models.dtos.asset.AddAcquiredAssetDTO;
import com.example.collateralmanagement.models.dtos.asset.DisplayAcquiredAssetDTO;
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
    @GetMapping("/add")
    public String displayAddAcquiredAsset(Model model, String owner){

            List<DisplayAssetDTO> displayAssetDTOS = this.assetService.findAssetsByOwnerName(owner);
            model.addAttribute("displayAssetDTOS", displayAssetDTOS);
            model.addAttribute("owner",owner);

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
