import React, { useEffect, useState } from 'react'
import api from './api'

export default function App(){
  const [employees, setEmployees] = useState([])
  const [form, setForm] = useState({name:'', email:'', role:'', baseSalary:0})
  const [payrollForm, setPayrollForm] = useState({employeeId:'', month:1, year:new Date().getFullYear(), basic:0, allowances:0, deductions:0})
  const [payrolls, setPayrolls] = useState([])

  const load = async () => {
    const e = await api.get('/employees'); setEmployees(e.data)
    const p = await api.get('/payrolls'); setPayrolls(p.data)
  }
  useEffect(()=>{ load() }, [])

  const createEmployee = async (e) => {
    e.preventDefault()
    await api.post('/employees', {...form, baseSalary: Number(form.baseSalary)})
    setForm({name:'', email:'', role:'', baseSalary:0})
    load()
  }

  const generatePayroll = async (e) => {
    e.preventDefault()
    await api.post('/payrolls/generate', {
      employeeId: Number(payrollForm.employeeId),
      month: Number(payrollForm.month),
      year: Number(payrollForm.year),
      basic: Number(payrollForm.basic),
      allowances: Number(payrollForm.allowances),
      deductions: Number(payrollForm.deductions),
    })
    load()
  }

  return (
    <div style={{maxWidth:900, margin:'40px auto', fontFamily:'Inter, system-ui, Arial'}}>
      <h1>Payroll Management</h1>

      <section style={{display:'grid', gridTemplateColumns:'1fr 1fr', gap:24}}>
        <div>
          <h2>New Employee</h2>
          <form onSubmit={createEmployee} style={{display:'grid', gap:8}}>
            <input required placeholder="Name" value={form.name} onChange={e=>setForm({...form, name:e.target.value})}/>
            <input required type="email" placeholder="Email" value={form.email} onChange={e=>setForm({...form, email:e.target.value})}/>
            <input required placeholder="Role" value={form.role} onChange={e=>setForm({...form, role:e.target.value})}/>
            <input required type="number" placeholder="Base Salary" value={form.baseSalary} onChange={e=>setForm({...form, baseSalary:e.target.value})}/>
            <button type="submit">Create</button>
          </form>

          <h2 style={{marginTop:24}}>Employees</h2>
          <ul>
            {employees.map(e => (
              <li key={e.id}>
                {e.name} — {e.email} — {e.role} — ₹{e.baseSalary}
              </li>
            ))}
          </ul>
        </div>

        <div>
          <h2>Generate Payroll</h2>
          <form onSubmit={generatePayroll} style={{display:'grid', gap:8}}>
            <select required value={payrollForm.employeeId} onChange={e=>setPayrollForm({...payrollForm, employeeId:e.target.value})}>
              <option value="">Select employee</option>
              {employees.map(e => (<option key={e.id} value={e.id}>{e.name}</option>))}
            </select>
            <input type="number" min="1" max="12" placeholder="Month (1-12)" value={payrollForm.month} onChange={e=>setPayrollForm({...payrollForm, month:e.target.value})}/>
            <input type="number" placeholder="Year" value={payrollForm.year} onChange={e=>setPayrollForm({...payrollForm, year:e.target.value})}/>
            <input type="number" placeholder="Basic" value={payrollForm.basic} onChange={e=>setPayrollForm({...payrollForm, basic:e.target.value})}/>
            <input type="number" placeholder="Allowances" value={payrollForm.allowances} onChange={e=>setPayrollForm({...payrollForm, allowances:e.target.value})}/>
            <input type="number" placeholder="Deductions" value={payrollForm.deductions} onChange={e=>setPayrollForm({...payrollForm, deductions:e.target.value})}/>
            <button type="submit">Generate</button>
          </form>

          <h2 style={{marginTop:24}}>All Payrolls</h2>
          <ul>
            {payrolls.map(p => (
              <li key={p.id}>
                EMP #{p.employee?.id} — {p.month}/{p.year} — Net: ₹{p.netPay}
              </li>
            ))}
          </ul>
        </div>
      </section>
    </div>
  )
}
