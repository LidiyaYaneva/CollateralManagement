package com.example.collateralmanagement.web;

import com.example.collateralmanagement.models.dtos.asset.CreateAssetDTO;
import com.example.collateralmanagement.models.dtos.business.AddClientDTO;
import com.example.collateralmanagement.services.AssetService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/collaterals/assets")
public class AssetController {

    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @ModelAttribute("addClientDTO")
    public CreateAssetDTO initForm(Model model){
        CreateAssetDTO createAssetDTO = new CreateAssetDTO();
        model.addAttribute("createAssetDTO",createAssetDTO);
        return createAssetDTO;
    }

    @GetMapping("/addNewAsset")
    public String displayAddClientForm (){

        return "addAsset";
    }

    @PostMapping( "/save")
    public String saveClient (@Valid CreateAssetDTO createAssetDTO, BindingResult bindingResult,
                              RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("createAssetDTO", createAssetDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.createAssetDTO", bindingResult);
            return "redirect:/collaterals/assets/addNewAsset";
        }
        this.assetService.createAsset(createAssetDTO);
        return "redirect:/collaterals/addCollateralFromAsset";

    }


}
