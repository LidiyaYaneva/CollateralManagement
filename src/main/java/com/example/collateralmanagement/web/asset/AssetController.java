package com.example.collateralmanagement.web.asset;

import com.example.collateralmanagement.models.dtos.asset.CreateAssetDTO;
import com.example.collateralmanagement.models.dtos.asset.DisplayAssetDTO;
import com.example.collateralmanagement.models.dtos.asset.SearchDTO;
import com.example.collateralmanagement.models.dtos.business.AddClientDTO;
import com.example.collateralmanagement.models.enums.DepartmentEnum;
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

import java.util.List;

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

    @GetMapping("/findAsset")
    public String displaySearchAsset(Model model, SearchDTO searchDTO){

        List<DisplayAssetDTO> displayAssetDTOS = this.assetService.findAssetsBySearchInput(searchDTO);
        model.addAttribute("displayAssetDTOS", displayAssetDTOS);
        model.addAttribute("searchDTO", searchDTO);

        return "findAssets";

    }
    @ModelAttribute("searchDTO")
    public SearchDTO initSearch(Model model){
        SearchDTO searchDTO = new SearchDTO();
        model.addAttribute("searchDTO",searchDTO);
        return searchDTO;
    }
}
