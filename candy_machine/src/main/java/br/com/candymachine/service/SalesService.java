package br.com.candymachine.service;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.candymachine.model.ResponseModel;
import br.com.candymachine.model.SalesModel;
import br.com.candymachine.repository.SalesRepository;

@Service
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/service")
public class SalesService {

	@Autowired
	private SalesRepository salesRepository;

	/**
	 * SALVAR UM NOVO REGISTRO
	 * 
	 * @param sale
	 * @return
	 */
	@RequestMapping(value = "/sales", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel insert(@RequestBody SalesModel sale) {

		String message = calculateChange(sale.getFinalValue(), sale.getValue());

		sale.setDate(new Date());
		
		System.out.println("SALE: " + sale.toString());
		
		if(message.contains("insuficiente")) {
			return new ResponseModel(1, message.substring(0, 37));
		} else {
			sale.setChange(Double.parseDouble(message.substring(10, 14).replace(',', '.')));
			try {
				this.salesRepository.save(sale);
				return new ResponseModel(1, message);
			} catch (Exception e) {
				return new ResponseModel(0, e.getMessage());
			}
		}
	}

	/* Método utilizado para calcular o troco */
	private static String calculateChange(double totalAmount, double paidAmount) {
		DecimalFormat formatador = new DecimalFormat("###,##0.00");
		if (paidAmount < totalAmount)
			return ("Pagamento insuficiente, faltam R$" + formatador.format(totalAmount - paidAmount) + "\n");
		else {
			int noteBills[] = { 100, 50, 20, 10, 5, 2, 1 };
			int cents[] = { 50, 25, 10, 5, 1 };

			String result;
			double change;
			int i, value, ct;

			change = paidAmount - totalAmount;
			result = "Troco = R$" + formatador.format(change) + ". ";

			// definindo as notas do troco (parte inteira)
			value = (int) change;
			i = 0;
			while (value != 0) {
				ct = value / noteBills[i]; // calculando a quantidade de notas
				if (ct != 0) {
					result = result + (ct + " nota(s) de R$" + noteBills[i] + ", ");
					value = value % noteBills[i]; // sobra
				}
				i = i + 1; // próxima nota
			}

			// Definindo os centavos do troco (parte fracionária)
			value = (int) Math.round((change - (int) change) * 100);
			i = 0;
			while (value != 0) {
				ct = value / cents[i]; // Calculando a qtde de moedas
				if (ct != 0) {
					result = result + (ct + " moeda(s) de " + cents[i] + " centavo(s), ");
					value = value % cents[i]; // Sobra
				}
				i = i + 1; // Próximo centavo
			}

			return (result);
		}
	}

	/**
	 * ATUALIZAR O REGISTRO DE UMA VENDA
	 * 
	 * @param sale
	 * @return
	 */
	@RequestMapping(value = "/sales", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel update(@RequestBody SalesModel sale) {

		try {

			this.salesRepository.save(sale);

			return new ResponseModel(1, "Registro atualizado com sucesso!");

		} catch (Exception e) {

			return new ResponseModel(0, e.getMessage());
		}
	}

	/**
	 * CONSULTAR TODAS AS venda
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sales", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<SalesModel> select() {

		return this.salesRepository.findAll();
	}

	/**
	 * BUSCAR UMA PESSOA PELO CÓDIGO
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/sales/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody SalesModel find(@PathVariable("id") Integer id) {

		return this.salesRepository.findById(id);
	}

	/***
	 * EXCLUIR UM REGISTRO PELO CÓDIGO
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/sales/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel delete(@PathVariable("id") Integer id) {

		SalesModel salesModel = salesRepository.findById(id);

		try {

			salesRepository.delete(salesModel);

			return new ResponseModel(1, "Registro excluido com sucesso!");

		} catch (Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}

}
