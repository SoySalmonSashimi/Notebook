package com.example.Notebook.Service;

import com.example.Notebook.Dto.FinanceDto;
import com.example.Notebook.Entity.Finance;
import com.example.Notebook.Entity.User;
import com.example.Notebook.Repository.FinanceRepository;
import com.example.Notebook.Repository.UserRepository;
import com.example.Notebook.Utils.FinanceUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class FinancialService {

    private final FinanceRepository financialRepository;
    private final UserRepository userRepository;

    public FinancialService(FinanceRepository financeRepository, UserRepository userRepository)
    {
        this.financialRepository = financeRepository;
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = false)
    public FinanceDto createFinancialEntry(long userId, FinanceDto financeDto)
    {
        User user = userRepository.findById(userId).orElseThrow(()-> new EntityNotFoundException("User Not Found " + userId));
        Finance finance = FinanceUtil.fromDto(financeDto);
        finance.setUser(user);
        Finance saved =financialRepository.save(finance);
        return FinanceUtil.toDto(saved);
    }

    @Transactional(readOnly = true)
    public FinanceDto getFinanceEntryById( long entryId)
    {
        Finance finance = financialRepository.findById(entryId).orElseThrow(()-> new EntityNotFoundException("User Not Found" + entryId));
        return FinanceUtil.toDto(finance);

    }

    @Transactional(readOnly = true)
    public List<FinanceDto> getAllFinanceEntryById(long userId)
    {
        List<Finance> finance = financialRepository.findByUserUserId(userId);
        return FinanceUtil.toDtoList(finance);

    }

}
