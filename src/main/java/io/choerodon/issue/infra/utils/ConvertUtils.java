package io.choerodon.issue.infra.utils;

import io.choerodon.issue.api.dto.IssueTypeDTO;
import io.choerodon.issue.api.dto.StateMachineSchemeConfigDTO;
import io.choerodon.issue.api.dto.StateMachineSchemeDTO;
import io.choerodon.issue.domain.IssueType;
import io.choerodon.issue.domain.StateMachineScheme;
import io.choerodon.issue.domain.StateMachineSchemeConfig;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author peng.jiang@hand-china.com
 */
public class ConvertUtils {
    private ConvertUtils() {
    }


    public static StateMachineSchemeDTO convertStateMachineSchemeToDTO(final StateMachineScheme scheme) {
        ModelMapper modelMapper = new ModelMapper();
        StateMachineSchemeDTO schemeDTO = modelMapper.map(scheme, StateMachineSchemeDTO.class);
        List<StateMachineSchemeConfig> schemeConfigs = scheme.getSchemeConfigs();
        if (null != schemeConfigs && !schemeConfigs.isEmpty()){
            List<StateMachineSchemeConfigDTO> schemeConfigDTOS = modelMapper.map(schemeConfigs,new TypeToken<List<StateMachineSchemeConfigDTO>>(){}.getType());
            schemeDTO.setConfigDTOs(schemeConfigDTOS);
        }
        return schemeDTO;
    }

    public static List<StateMachineSchemeDTO> convertStateMachineSchemesToDTOs(final List<StateMachineScheme> schemes) {
        List<StateMachineSchemeDTO> list = new ArrayList<>(schemes.size());
        for (StateMachineScheme scheme:schemes) {
            StateMachineSchemeDTO schemeDTO = convertStateMachineSchemeToDTO(scheme);
            list.add(schemeDTO);
        }
        return list;
    }

    public static List<IssueTypeDTO> convertIssueTypesToDTOs(final List<IssueType> issueTypes) {
        if (issueTypes == null || issueTypes.isEmpty()){
            return Collections.emptyList();
        }
        ModelMapper modelMapper = new ModelMapper();
        List<IssueTypeDTO> list = new ArrayList<>(issueTypes.size());
        for (IssueType issueType:issueTypes) {
            IssueTypeDTO issueTypeDTO = modelMapper.map(issueType, IssueTypeDTO.class);
            if (issueType.getStateMachineSchemeConfig() != null){
                StateMachineSchemeConfigDTO configDTO = modelMapper.map(issueType.getStateMachineSchemeConfig(),StateMachineSchemeConfigDTO.class);
                issueTypeDTO.setStateMachineSchemeConfigDTO(configDTO);
            }
            list.add(issueTypeDTO);
        }
        return list;
    }

}